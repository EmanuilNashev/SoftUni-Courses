package ObjectsAndClasses.MoreExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CompanyRoasterBestVersion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Department> departments = new ArrayList<>();

        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfEmployees; i++) {
            String[] employeeParameters = scanner.nextLine().split("\\s+");
            String name = employeeParameters[0];
            double salary = Double.parseDouble(employeeParameters[1]);
            String position = employeeParameters[2];
            String departmentName = employeeParameters[3];


            Employee employee = getEmployeeData(name, salary, position, employeeParameters);
            Department department = getDepartmentData(employee, departmentName);

            checkListAndAdd(departments, departmentName, employee, department);
        }

        Department departmentWithHighestAverageSalary = getDepartmentWithHighestAverageSalary(departments);

        departmentWithHighestAverageSalary = getDepartmentWithHighestAverageSalaryInDescendingOrder(departmentWithHighestAverageSalary);

        outPut(departmentWithHighestAverageSalary);

    }

    private static Department getDepartmentWithHighestAverageSalaryInDescendingOrder(Department department) {

        Department newDepartment = new Department();
        newDepartment.setDepartment(department.getDepartment());
        for (int i = 0; i < department.getEmployees().size(); i++) {
            double maxSalary = Double.MIN_VALUE;
            Employee employee = new Employee();

            int index = 0;
            for (int j = 0; j < department.getEmployees().size(); j++) {
                if (department.getEmployees().get(j).getSalary()>maxSalary){
                    maxSalary = department.getEmployees().get(j).getSalary();
                    index = j;
                    employee = department.getEmployees().get(j);

                }
            }
            //TODO check
            newDepartment.getEmployees().add( employee);
            department.getEmployees().remove(index);
            i--;

        }
        department = newDepartment;
        return department;

    }

    private static void outPut(Department department) {
        System.out.println("Highest Average Salary: " + department.getDepartment());
        for (int i = 0; i < department.getEmployees().size(); i++) {
            System.out.println(department.getEmployees().get(i).getName() + " " + String.format("%.2f", department.getEmployees().get(i).getSalary()) + " " +
                    department.getEmployees().get(i).getEmail() + " " + department.getEmployees().get(i).getAge());
        }
    }

    private static Department getDepartmentWithHighestAverageSalary(List<Department> departments) {

        double maxAverageSalary = Double.MIN_VALUE;
        Department department = new Department();

        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getAverageSalary() > maxAverageSalary) {
                maxAverageSalary = departments.get(i).getAverageSalary();
                department = departments.get(i);
            }
        }
        return department;
    }

    private static void checkListAndAdd(List<Department> departments, String departmentName, Employee employee, Department department) {

        boolean flag = false;
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getDepartment().equals(departmentName)) {
                departments.get(i).getEmployees().add(employee);
                flag = true;
                break;
            }
        }
        if (!flag) {
            departments.add(department);
        }
    }

    private static Department getDepartmentData(Employee employee, String departmentName) {
        Department department = new Department();
        department.setDepartment(departmentName);
        department.getEmployees().add(employee);
        return department;

    }

    private static Employee getEmployeeData(String name, double salary, String position, String[] employeeParameters) {
        Employee employee = new Employee(name, salary, position);
        if (employeeParameters.length == 5) {
            if (employeeParameters[4].contains("@")) {
                employee.setEmail(employeeParameters[4]);
            } else {
                employee.setAge(Integer.parseInt(employeeParameters[4]));
            }
        } else if (employeeParameters.length == 6) {
            employee.setEmail(employeeParameters[4]);
            employee.setAge(Integer.parseInt(employeeParameters[5]));
        }
        return employee;
    }

    static class Employee {
        String name;
        double salary;
        String position;
        String email = "n/a";
        int age = -1;

        public Employee(){

        }

        public Employee(String name, double salary, String position) {
            this.name = name;
            this.salary = salary;
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public String getPosition() {
            return position;
        }

        public String getEmail() {
            return email;
        }

        public int getAge() {
            return age;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    static class Department {
        String department;
        List<Employee> employees = new ArrayList<>();



        public String getDepartment() {
            return department;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public double getAverageSalary() {
            double sum = 0;
            for (int i = 0; i < employees.size(); i++) {
                sum += employees.get(i).getSalary();
            }
            return sum / employees.size();
        }

    }
}
