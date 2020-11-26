package Practic_23_24;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Worker {
    private final String taskPath = "http://gitlessons2020.rtuitlab.ru:3000/tasks";
    private final String reportPath = "http://gitlessons2020.rtuitlab.ru:3000/reports";
    private final String filePath = "src/main/java/Practic_23_24";
    private final Gson gson = new Gson();
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final File file = new File(filePath + "/db.json");
    private final Random random = new Random();
    private List<Integer> idCompleteList = new ArrayList<>();
    private List<Integer> idList = new ArrayList<>();
    private long period = random.nextInt(2000 - 1000) + 1000;

    public Worker() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mainWork(){
        while (true) {
            Thread thread = new Thread(() -> work());
            thread.start();
            try {
                thread.join();
                Thread.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            period = random.nextInt(2000 - 1000) + 1000;
        }

    }


    public void work() {
        List<Task> notifyTasks;
        idCompleteList = getIdCompleteTask();
        idList = getIdTask();
        if (!idCompleteList.equals(idList)) {
            notifyTasks = findNotifyTask(getIdCompleteTask(), getAllTask());
            for (Task task : notifyTasks) {
                postReport(new Report(0,
                        task.getId(),
                        getResponseExpression(task.getExpression())));
                idCompleteList.add(task.getId());
                System.out.println(task.getId()+"     "+getResponseExpression(task.getExpression()));
            }
            writeCompleteTask(idCompleteList);
        }
    }

    private List<Task> getAllTask() {
        Type collectionType = new TypeToken<Collection<Task>>() {
        }.getType();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(taskPath))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<Task> itemList = gson.fromJson(response.body(), collectionType);
            return itemList;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void postReport(Report rpt) {
        String body = gson.toJson(rpt);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(reportPath))
                .setHeader("Content-Type", "application/json")
                .build();
        try {
            httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeCompleteTask(List<Integer> tmp) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(gson.toJson(tmp));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<Integer> getIdCompleteTask() {
        List<Integer> tmp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Type collectionType = new TypeToken<Collection<Integer>>() {
        }.getType();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            line = reader.readLine();
            while (line != null) {
                sb.append(line);
                line = reader.readLine();
            }
            tmp = gson.fromJson(sb.toString(), collectionType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    private List<Integer> getIdTask() {
        List<Integer> tmp = new ArrayList<>();
        for (Task task : getAllTask()) {
            tmp.add(task.getId());
        }
        return tmp;
    }

    private List<Task> findNotifyTask(List<Integer> integerList, List<Task> taskList) {
        List<Task> tmp = new ArrayList<>();
        boolean flag = false;
        for (Task task : taskList) {
            for (int id : integerList) {
                if (id == task.getId()) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                tmp.add(task);
            }
            flag = false;
        }
        return tmp;
    }


    public double getResponseExpression(String expression) {
        double first;
        double second;
        double resp = 0;
        double scale = Math.pow(10, 2);
        Pattern pattern = Pattern.compile("(?<firstNumber>^-?\\d*(\\.\\d+)?\\s*)(?<firstOperand>\\s*[+\\-*/])(?<secondNumber>\\s*-?\\d*(\\.\\d+)?$)");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            first = Double.valueOf(matcher.group("firstNumber"));
            second = Double.valueOf(matcher.group("secondNumber"));
            switch (matcher.group("firstOperand")) {
                case "+":
                    resp = first + second;
                    break;
                case "-":
                    resp = first - second;
                    break;
                case "*":
                    resp = first * second;
                    break;
                case "/":
                    resp = first / second;
                    break;
                default:
                    break;
            }
            resp = (Math.round(resp * scale)) / scale;
            return resp;
        }
        return 0;
    }

}
