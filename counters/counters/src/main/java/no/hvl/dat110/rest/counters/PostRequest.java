package no.hvl.dat110.rest.counters;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class PostRequest {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) {

        Todo todo = new Todo("2", "post", "posted");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, todo.toJson());

        Request request = new Request.Builder().url("http://localhost:8080/todo").post(body).build();

        System.out.println(request.toString());

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
