public class Foreman extends Employees {

    public Foreman(int empId, String employeeName, float salary) {
        super(empId, employeeName, salary);
    }

    @Override
    public void calculateSalary(float salary) {
        super.salary = salary * 10;
    }

    @Override
    public void displayDetails() {
        System.out.println("This Foreman is " + super.getEmployeeName() + ", having id of " + super.getEmpId()
                + ", making a salary of: " + super.salary);
    }

}
