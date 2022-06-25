package DefiningClasses.Exercises.CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Department {
    private String department;
    private List<Employee> employees;

    public Department(){

    }

    public Department(String department) {
        this.employees = new ArrayList<>();
        this.department = department;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public String getDepartment(){
        return this.department;
    }

    public double getAverageSalary() {
        double totalSalary = 0;
        for (int i = 0; i < this.employees.size(); i++) {
            totalSalary += this.employees.get(i).getSalary();
        }
        return totalSalary / this.employees.size();
    }

    public List<Employee> sorted(){
       return this.employees.stream().sorted((e1,e2)-> {
            if(e1.getSalary() < e2.getSalary()){
                return 1;
            }else if (e1.getSalary() == e2.getSalary()){
                return 0;
            }
            return -1;
        }).collect(Collectors.toList());
    }


}
