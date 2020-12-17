package Practic_27_28;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Method;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class TestMain {
    static Gson gson = new Gson();
    static HttpClient httpClient = HttpClient.newHttpClient();

    public static void main(String[] args){
        Worker worker = new Worker();
        Class<Worker> workerClass = Worker.class;
        URI uri = URI.create("http://gitlessons2020.rtuitlab.ru:3000/reflectionTasks");
        List<Method> methods = Arrays.stream(workerClass.getDeclaredMethods())
                .filter(a -> a.isAnnotationPresent(ConsoleOperation.class))
                .collect(Collectors.toList());
        ArrayList<Task> tasks = (ArrayList<Task>) getAllTask(uri);
        //System.out.println(methods.size());
        //System.out.println(workerClass.getDeclaredMethods().length);
        try {
            for (Task task : tasks) {
                List<Method> tmpMethods = methods.stream().filter(a->a.getName().equals(task.getType())).collect(Collectors.toList());
                for(Method method:tmpMethods){
                    method.invoke(worker,task.getData());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
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
