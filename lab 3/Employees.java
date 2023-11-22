public abstract class Employees {
    private final int empId;
    private final String employeeName;
    protected float salary;

    public Employees(int empId, String employeeName, float salary) {
        this.empId = empId;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public abstract void calculateSalary(float salary);

    public abstract void displayDetails();
}