package Practic_09;

public class Holder implements EmployeeHolder{
    @Override
    public void holderEmployee(Employee employee, int index) {
        System.out.println(index+"----------"+employee);
    }
}
