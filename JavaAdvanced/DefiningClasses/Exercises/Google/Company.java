package DefiningClasses.Exercises.Google;

public class Company {
    private String companyName;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.companyName = name;
        this.department = department;
        this.salary = salary;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getDepartment() {
        return this.department;
    }

    public double getSalary(){
        return this.salary;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
