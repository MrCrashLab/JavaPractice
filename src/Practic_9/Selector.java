package Practic_9;

public class Selector implements EmployeeSelector {
    private int year;

    public Selector(int year) {
        this.year = year;
    }

    @Override
    public boolean isNeedEmployee(Employee employee) {
        return employee.getDateOfBirth().getYear() > this.year;
    }
}
