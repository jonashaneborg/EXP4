package no.hvl.dat110.rest.counters;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.put;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
	
	static Todo todo = null;
	
	public static void main(String[] args) {

		if (args.length > 0) {
			port(Integer.parseInt(args[0]));
		} else {
			port(8080);
		}

		todo = new Todo();
		todo.setDescription("Go gym");
		todo.setSummary("Get strong");

		
		after((req, res) -> {
  		  res.type("application/json");
  		});
		
        get("/todo", (req, res) -> todo.toJson());
               
        put("/todo", (req,res) -> {

        	Gson gson = new Gson();

        	todo = gson.fromJson(req.body(), Todo.class);

            return todo.toJson();

        });
    }
    
}
