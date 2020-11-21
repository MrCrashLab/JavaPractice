package Practic_21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HttpJsonItemsStore implements ItemsStore{
    HttpClient httpClient = HttpClient.newHttpClient();
    Gson gson = new Gson();
    String path = "http://localhost:3000/object";

    @Override
    public List<Item> getAllItem() {
        Type collectionType = new TypeToken<Collection<Item>>() {
        }.getType();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(path))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<Item> itemList = gson.fromJson(response.body().toString(),collectionType);
            return itemList;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Item getItem(int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(path+"/"+id))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            Item item = gson.fromJson(response.body().toString(),Item.class);
            System.out.println(gson.fromJson(response.body().toString(),Item.class));
            return item;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addItem(Item item) {
        String body = gson.toJson(item);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(path))
                .setHeader("Content-Type", "application/json")
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.body().toString().startsWith("Error"))
                return false;
            return true;
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editItem(int id, Item item) {
        String body = gson.toJson(item);
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(path+"/"+id))
                .setHeader("Content-Type", "application/json")
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.body().toString().startsWith("{}"))
                return false;
            System.out.println(response.body());
            return true;
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteItem(int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(path+"/"+id))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
