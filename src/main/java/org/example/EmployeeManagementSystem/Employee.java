package org.example.EmployeeManagementSystem;

public class Employee {
    private static int countId = 1;
    private int id;
    private String firstname;
    private String lastname;
    private String position;
    private double salary;

    public Employee(String firstname, String lastname, String position, double salary) {
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

    public void displayInfo() {
        System.out.println("Данные о сотруднике: " +
                        "\n Уникальный идентификатор " + id +
                        "\n Имя " + firstname +
                        "\n Фамилиия " + lastname +
                        "\n Должность " + position +
                        "\n Заработная плата " + salary + "\n");
    }

    public void getAnnualSalary() {
        double yearSalary = salary * 12;
        System.out.println("Годовая зарплата сотрудника: " + yearSalary);
    }

    public void raiseSalary(double percent) {
        if (percent == 0) {
            System.out.println("Зарплата не увеличилась, у сотрудника " + lastname + " В должности " + position);
        } else if (percent < 0) {
            System.out.println("Невозможно указать процент ниже 0");
        } else {
            double persentSalary = (salary * percent / 100) + salary;
            System.out.println("Зарплата сотрудника " + firstname
                    + " повысилась до " + persentSalary + " на " + percent + "%\n");
            salary = persentSalary;
        }


    }

}

class Develop extends Employee{
        private String language;


    public Develop(Employee employee, String language) {
        super(employee.getFirstname(), employee.getLastname(), "Разработчик", employee.getSalary());
        this.language = language;
    }

    public String getLanguage()  {
        return language;
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "\n Имя " + getFirstname() +
                "\n Фамилиия " + getLastname() +
                "\n Язык программирования " + language +
                "\n Заработная плата " + getSalary() + "\n");
    }


}
class Tester extends Employee{
    private String type;

    public Tester(Employee employee, String type) {
        super(employee.getFirstname(), employee.getLastname(), "QA Engineer", employee.getSalary());
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void displayInfo(){
        System.out.println(
                "\n Имя " + getFirstname() +
                        "\n Фамилиия " + getLastname() +
                        "\n Тип тестирования " + type +
                        "\n Заработная плата " + getSalary() + "\n");
    }


}







