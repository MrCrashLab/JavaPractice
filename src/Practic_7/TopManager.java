package Practic_7;

import java.util.Random;

public class TopManager implements EmployeePosition {

    @Override
    public String getJobTitle() {
        return "Top Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }
}
