public class SiteManager extends Employees {

    public SiteManager(int empId, String employeeName, float salary) {
        super(empId, employeeName, salary);
    }

    @Override
    public void calculateSalary(float salary) {
        super.salary = salary * 5;
    }

    @Override
    public void displayDetails() {
        System.out.println("This SiteManager is " + super.getEmployeeName() + ", having id of " + super.getEmpId()
                + ", making a salary of: " + super.salary);
    }

}
