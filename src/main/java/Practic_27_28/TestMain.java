package Practic_27_28;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class TestMain {
    static Gson gson = new Gson();
    static HttpClient httpClient = HttpClient.newHttpClient();
    public static void main(String[] args){
        Worker worker = new Worker();
        Class<Worker> workerClass = Worker.class;
        URI uri = URI.create("http://gitlessons2020.rtuitlab.ru:3000/reflectionTasks");
        ArrayList<Task> tasks = (ArrayList<Task>) getAllTask(uri);
        try {
            for (Task task : tasks) {
                workerClass.getDeclaredMethod(task.getType(), Data.class).invoke(worker, task.getData());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    static public List getAllTask(URI uri) {
        Type collectionType = new TypeToken<Collection<Task>>() {
        }.getType();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<Task> taskList = gson.fromJson(response.body(), collectionType);
            return taskList;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
