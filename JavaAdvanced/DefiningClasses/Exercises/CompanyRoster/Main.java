package DefiningClasses.Exercises.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Department> departments = new HashMap<>();

        int linesOfInformation = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linesOfInformation; i++) {
            String[] employeeData = scanner.nextLine().split("\\s+");

            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];
            String email;
            int age;

            Employee employee = null;
            switch (employeeData.length) {
                case 6:
                    email = employeeData[4];
                    age = Integer.parseInt(employeeData[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
                case 5:
                    if (employeeData[4].contains("@")) {
                        email = employeeData[4];
                        employee = new Employee(name, salary, position, department, email);
                    } else {
                        age = Integer.parseInt(employeeData[4]);
                        employee = new Employee(name, salary, position, department, age);
                    }
                    break;
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
            }

            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);
        }

        Department departmentWithHighestAverageSalary = getAverageHighestSalary(departments);

        System.out.println("Highest Average Salary: " + departmentWithHighestAverageSalary.getDepartment());
        departmentWithHighestAverageSalary.sorted().forEach(System.out::println);
    }

    private static Department getAverageHighestSalary(Map<String, Department> departments) {
        Department department = new Department();
        double maxSalary = Double.MIN_VALUE;
        for (var departmentsEntrySet : departments.entrySet()) {
            if (maxSalary < departmentsEntrySet.getValue().getAverageSalary()) {
                maxSalary = departmentsEntrySet.getValue().getAverageSalary();
                department = departmentsEntrySet.getValue();
            }
        }
        return department;
    }
}
