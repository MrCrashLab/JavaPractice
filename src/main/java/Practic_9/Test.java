package Practic_9;

import java.time.LocalDate;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Company company = new Company();
        Random random = new Random();
        Holder holder = new Holder();
        Selector selector = new Selector(1980);
        final String[] name = {"Jack", "Leonardo", "Sarah", "Arnold", "Tony", "John", "Albert", "Anna", "Donatello"};
        final String[] secondName = {"Smith", "Parker", "Einstein", "Edison", "Tordvalds", "Gates"};
        final String[] location = {"Moscow", "New-York", "London"};
        for (int i = 0; i < 100; i++)
            company.hire(new Employee(
                    name[i % 9],
                    secondName[i % 6],
                    LocalDate.of(random.nextInt(2002 - 1960) + 1960, random.nextInt(11) + 1, random.nextInt(27) + 1),
                    location[i % 3],
                    "8800-555-35-35",
                    random.nextInt(1_000)));
        System.out.println("Salary more 900");
        company.handleEmployees(new EmployeeHolder() {
            @Override
            public void holderEmployee(Employee employee, int index) {
                System.out.println(index + "//////////" + employee);
            }
        }, new EmployeeSelector() {
            @Override
            public boolean isNeedEmployee(Employee employee) {
                return employee.getSalary() > 900;
            }
        });
        System.out.println("Second name "+ secondName[5]);
        company.handleEmployees(
                (employee, index) -> System.out.println(index + "++++++++++" + employee),
                employee -> employee.getSecondName().equals(secondName[5]));

        System.out.println("Later 1980");
        company.handleEmployees(holder, selector);
    }


}
