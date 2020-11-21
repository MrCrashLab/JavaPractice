package Practic_7_8;

import java.util.Random;

public class Manager implements EmployeePosition {
    private Random random = new Random();
    private int money = 0;

    public int generateMoney() {
        this.money = random.nextInt(140_000 - 115_000) + 115_000;
        return money;
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + money * 0.05;
    }
}
