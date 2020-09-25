package no.hvl.dat110.rest.counters;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    List<Todo> list;

    public TodoService() {
        list = new ArrayList<Todo>();
    }


    public void addTodo(Todo todo){
        list.add(todo);
    }

    public List<Todo> getTodos (){
        return list;
    }

    public Todo getTodo (String id){
        for (Todo t : list){
            if (t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }


    public void deleteTodo (String id){
        for (Todo t : list){
            if (t.getId().equals(id)){
                list.remove(t);
            }
        }
    }

    public boolean todoExist (String id){
        for (Todo t : list){
            if (t.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
