package Practic_7;

import java.util.List;

public class Test {
    Company company = new Company();
    private int baseSalary = 100_000;
    private final String[] name = {"Jack", "Leonardo", "Sarah", "Arnold", "Tony", "John", "Albert", "Anna", "Donatello"};
    private final String[] secondName = {"Smith", "Parker", "Einstein", "Edison", "Tordvalds", "Gates"};

    public Test() {
        createCompany();
        company.calcIncome();
        outputTopSalary(12);
        removeEmployee();
        outputTopSalary(15);
        outputLowSalary(30);
    }

    public void createCompany() {
        for (int i = 0; i < 180; i++)
            company.hire(new Employee(name[i % 9], secondName[i % 6], baseSalary, new Operator()));
        for (int i = 0; i < 80; i++)
            company.hire(new Employee(name[(i + 2) % 9], secondName[(i + 4) % 6], baseSalary, new Manager()));
        for (int i = 0; i < 10; i++)
            company.hire(new Employee(name[(i + 5) % 9], secondName[(i + 3) % 6], baseSalary, new TopManager(company)));
    }

    public void removeEmployee() {
        System.out.println("Увольнение!!!");
        for (int i = 0; i < company.getStaffSize(); i += 1)
            company.fire(i);
    }

    public void outputTopSalary(int num) {
        List<Employee> tmp;
        tmp = company.getTopSalaryStaff(num);
        System.out.println(num + " высоких зарплат!");
        for (int i = 0; i < num; i++) {
            System.out.printf("%,d", (int) tmp.get(i).getPosition().calcSalary(tmp.get(i).getBaseSalary()));
            System.out.println(" руб\t\t" + tmp.get(i).getPosition().getJobTitle());
        }
    }

    public void outputLowSalary(int num) {
        List<Employee> tmp;
        tmp = company.getLowestSalaryStaff(num);
        System.out.println(num + " низких зарплат!");
        for (int i = 0; i < num; i++) {
            System.out.printf("%,d", (int) tmp.get(i).getPosition().calcSalary(tmp.get(i).getBaseSalary()));
            System.out.println(" руб\t\t" + tmp.get(i).getPosition().getJobTitle());
        }
    }

    public static void main(String[] args) {
        new Test();
    }
}
