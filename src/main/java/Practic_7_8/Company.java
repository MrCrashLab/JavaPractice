package Practic_7_8;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private double income = 0;
    private ArrayList<Employee> employeeList = new ArrayList<>();


    public void hire(Employee employee) {
        employeeList.add(employee);
        calcIncome();
    }

    public void hireAll(ArrayList<Employee> listEmployee) {
        employeeList.addAll(listEmployee);
        calcIncome();
    }

    public void fire(Employee employee) {
        employeeList.remove(employee);
        calcIncome();
    }

    public void fire(int index) {
        employeeList.remove(index);
        calcIncome();
    }

    List<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> tmp = employeeList;
        Employee tm;
        for (int i = 0; i < tmp.size() - 1; i++)
            for (int j = i + 1; j < tmp.size(); j++) {
                if (tmp.get(i).getPosition().calcSalary(tmp.get(i).getBaseSalary()) < tmp.get(j).getPosition().calcSalary(tmp.get(j).getBaseSalary())) {
                    tm = tmp.get(j);
                    tmp.set(j, tmp.get(i));
                    tmp.set(i, tm);
                }
            }
        return tmp.subList(0, count);
    }

    List<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> tmp = employeeList;
        Employee tm;
        for (int i = 0; i < tmp.size() - 1; i++)
            for (int j = i + 1; j < tmp.size(); j++) {
                if (tmp.get(i).getPosition().calcSalary(tmp.get(i).getBaseSalary()) > tmp.get(j).getPosition().calcSalary(tmp.get(j).getBaseSalary())) {
                    tm = tmp.get(j);
                    tmp.set(j, tmp.get(i));
                    tmp.set(i, tm);
                }
            }
        return tmp.subList(0, count);
    }

    public void calcIncome() {
        this.income = 0;
        for (Employee emp : employeeList)
            if (emp.getPosition() instanceof Manager) {
                income += ((Manager) emp.getPosition()).generateMoney();
            }
    }

    public double getIncome() {
        return income;
    }

    public int getStaffSize() {
        return employeeList.size();
    }
}
