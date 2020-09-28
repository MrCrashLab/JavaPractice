package Practic_7;

import java.util.Random;

public class Manager implements EmployeePosition {
    private Random random = new Random();

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return 0;//baseSalary + (random.nextInt(140_000 - 115_000) + 115_000) * 0.05;
    }
}
