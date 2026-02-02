package org.example.EmployeeManagementSystem;

public class Employee {
    private static int countId = 1;
    private int id;
    private String firstname;
    private String lastname;
    private String position;
    private double salary;

    public Employee(int id, String firstname, String lastname, String position, double salary) {
        this.id = countId++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
        this.salary = salary;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }


}
