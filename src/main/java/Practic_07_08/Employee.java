package Practic_07_08;

public class Employee {
    private String name;
    private String secondName;
    private double baseSalary;
    private EmployeePosition position;

    public Employee(String name, String secondName, int baseSalary, EmployeePosition position) {
        this.name = name;
        this.secondName = secondName;
        this.baseSalary = baseSalary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public EmployeePosition getPosition() {
        return position;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }
}
