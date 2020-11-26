package Practic_23_24;

public class Report {
    private final String worker = "Dudarev";
    private int id;
    private int taskId;
    private double result;

    public Report(int id, int taskId, double result) {
        this.id = id;
        this.taskId = taskId;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getWorker() {
        return worker;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
