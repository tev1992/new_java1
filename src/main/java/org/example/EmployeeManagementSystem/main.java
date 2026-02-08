package org.example.EmployeeManagementSystem;

public class main {
    public static void main(String[] args) {
        Employee qa1 = new Employee("Вася", "Васьков", "QA Engineer", 100000);
        Employee qa2 = new Employee("Вася2", "Васьков2", "QA Engineer2", 250000);
        Employee qa3 = new Employee("Петя1", "Петьков", "Менеджер1", 50000);
        Employee qa4 = new Employee("Петя2", "Петьков2", "Менеджер2", 70000);
        qa1.displayInfo();
        qa1.getAnnualSalary();
        qa2.displayInfo();
        qa1.raiseSalary(200);
        qa1.displayInfo();
        Departament dep1 = new Departament(" 'Обеспечение качества'");
        Departament dep2 = new Departament("Менеджеры");
        dep1.addEmployee(qa1);
        dep1.addEmployee(qa2);
        dep1.addEmployee(qa3);
        dep2.addEmployee(qa3);
        dep2.addEmployee(qa4);

        dep1.showEmployee();
        dep1.getTotalSalary();
        dep2.getTotalSalary();
        Develop develop = new Develop(qa1, "java");
        develop.displayInfo();

        dep1.countEmpInDep();

        Tester tester = new Tester(qa1, "Ручник");
        tester.displayInfo();


    }
}
