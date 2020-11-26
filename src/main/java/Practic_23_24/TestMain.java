package Practic_23_24;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestMain {
    public static void main(String[] args) {
        Worker worker = new Worker();
        //deleteItem(1821, 2846);
        worker.mainWork();
    }
/*
    public static void deleteItem(int id, int end) {
        HttpClient httpClient = HttpClient.newHttpClient();
        for (int i = id; i < end; i++) {
            HttpRequest request = HttpRequest.newBuilder()
                    .DELETE()
                    .uri(URI.create("http://gitlessons2020.rtuitlab.ru:3000/reports" + "/" + i))
                    .build();
            try {
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(i + "Delete");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

}
