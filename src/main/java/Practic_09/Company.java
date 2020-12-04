package Practic_09;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public void hire(Employee employee) {
        employeeList.add(employee);
    }

    public void hireAll(ArrayList<Employee> listEmployee) {
        employeeList.addAll(listEmployee);
    }

    public void fire(Employee employee) {
        employeeList.remove(employee);
    }

    public void fire(int index) {
        employeeList.remove(index);
    }

    public void handleEmployees(EmployeeHolder holder, EmployeeSelector selector){
        int count = 0;
        for (Employee emp: employeeList) {
                if(selector.isNeedEmployee(emp)) {
                    holder.holderEmployee(emp, count);
                    count++;
                }
        }
    }
}
