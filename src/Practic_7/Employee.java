package Practic_7;

public class Employee {
    private String name;
    private String secondName;
    private int baseSalary;
    private EmployeePosition position;

    public Employee(String name, String secondName, int baseSalary, EmployeePosition position) {
        this.name = name;
        this.secondName = secondName;
        this.baseSalary = baseSalary;
        this.position = position;
    }

    public String getName() {return name;}

    public String getSecondName() {return secondName;}

    public int getBaseSalary() {return baseSalary;}

    public EmployeePosition getPosition() {return position;}
}
