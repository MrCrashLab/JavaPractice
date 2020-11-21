package Practic_7_8;

public class TopManager implements EmployeePosition {
    Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "Top Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + ((company.getIncome() >= 10_000_000) ? (baseSalary * 1.5) : 0);
    }
}
