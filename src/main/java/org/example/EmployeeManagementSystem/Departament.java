package org.example.EmployeeManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Departament {
    private String name;
    private List<Employee> employees;
    private Employee manager;


    public Departament(String name) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.manager = null;
    }

    public String getName() {
        return name;
    }

    public Employee getManager() {
        return manager;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Сотрудник " + employee.getFirstname() +  " добавлен в отдел" + name);

    }

    public void delEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void showEmployee(){
        if (employees.isEmpty()) {
            System.out.println("Сотрудники не добавлены в отдел");
            return;
        }
        for (Employee emp : employees) {
            System.out.println("Сотрудники в отделе " + emp.getFirstname() + " " + emp.getLastname());


        }

    }

    public double getTotalSalary() {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.getSalary();
        }
        System.out.println(total);
        return total;

    }

    public int countEmpInDep() {
        int count = 0;
        for (Employee employee : employees) {
            count ++;
        }
        System.out.println("КОличество сотрудников в департамента  " + count);
        return count;

    }

}
