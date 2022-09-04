/**
 * Самая сложность
 */

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        EmployeeBook myEmployeeBook = new EmployeeBook(15);
        myEmployeeBook.fillEmployees(10);
        myEmployeeBook.printAll();
        System.out.println();
        myEmployeeBook.salaryIndex(50);
        System.out.println("После индексации:");
        myEmployeeBook.printAll();
        System.out.println();

        Random randDep = new Random();
        int department = randDep.nextInt(5) + 1;

        System.out.print("Сотрудник из отдела " + department + " с минимальной зарплатой: ");
        myEmployeeBook.printById(myEmployeeBook.minSalaryIdDepartment(department));
        System.out.print("Сотрудник из отдела " + department + " с максимальной зарплатой: ");
        myEmployeeBook.printById(myEmployeeBook.maxSalaryIdDepartment(department));
        System.out.println("Месячные затраты по отделу " + department + ": " + myEmployeeBook.summAllDepartment(department));
        System.out.printf("Средняя зарплата сотрудников из %d отдела: %.2f", department, myEmployeeBook.averageSalaryDepartment(department));
        System.out.println();

        myEmployeeBook.salaryIndexDepartment(department, 30);
        System.out.println("После индексации:");
        myEmployeeBook.printAllFromDepartment(department);
        System.out.println();

        Random randSalary = new Random();
        int sampleSalary = randSalary.nextInt(10000) + 100000;
        System.out.println("Сотрудники с зарплатой меньше " + sampleSalary);
        myEmployeeBook.printLessThan(sampleSalary);
        System.out.println();
        System.out.println("Сотрудники с зарплатой больше " + sampleSalary);
        myEmployeeBook.printMoreThan(sampleSalary);
        System.out.println();

        myEmployeeBook.addNewEmployee("Сидоров Денис Вадимович", 4, 99000);
        myEmployeeBook.addNewEmployee("Иванов Денис Леопольдович", 2, 109000);
        myEmployeeBook.printAll();
        System.out.println();
        myEmployeeBook.deleteEmployee("Сидоров Денис Вадимович");
        myEmployeeBook.printAll();
        System.out.println();

        myEmployeeBook.editEmployeeSalary("Иванов Денис Леопольдович", 200000);
        myEmployeeBook.editEmployeeDepartment("Иванов Денис Леопольдович", 5);
        myEmployeeBook.printAll();
        System.out.println();

        myEmployeeBook.printAllDepartment();


    }

}