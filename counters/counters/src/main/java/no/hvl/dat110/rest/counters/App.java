package no.hvl.dat110.rest.counters;

import com.google.gson.Gson;

import static spark.Spark.*;

/**
 * Hello world!
 */
public class App {

	static TodoService todoService = new TodoService();

	public static void main(String[] args) {

		if (args.length > 0)
			port(Integer.parseInt(args[0]));
		else
			port(8080);

		after((req, res) -> {
			res.type("application/json");
		});

		get("/todo", (req, res) -> new Gson().toJsonTree(todoService.getTodos()));
		get("/todo/:id", (req, res) -> new Gson().toJson(todoService.getTodo(req.params(":id"))));
		delete("/todo/:id", (req, res) -> {
			Todo todo = todoService.getTodo(req.params(":id"));
			String json = todo.toJson();
			todoService.deleteTodo(todo.getId());
			return json;
		});
		post("/todo", (req, res) -> {
			Todo todo = new Gson().fromJson(req.body(), Todo.class);
			todoService.addTodo(todo);
			return todo.toJson();
		});
		put("/todo/:id", (req, res) -> {
			Todo todo = todoService.getTodo(req.params(":id"));
			todoService.deleteTodo(todo.getId());
			todo = new Todo("9", "putted", "putted");
			todoService.addTodo(todo);
			return todo.toJson();
		});
	}

}
