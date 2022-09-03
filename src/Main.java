/**
 * Базовая сложность
 */

import java.util.Random;

public class Main {
    private static Employee[] employees;

    public static void main(String[] args) {
        employees = new Employee[10];
        fillEmployees(employees);
        printAll(employees);
        System.out.println();
        System.out.println("Сумма затрат: " + summAll(employees));
        System.out.println();
        System.out.print("Сотрудник с минимальной зарплатой: ");
        printById(employees, minSalaryId(employees));
        System.out.print("Сотрудник с максимальной зарплатой: ");
        printById(employees, maxSalaryId(employees));
        System.out.printf("Средняя зарплата сотрудников %.2f", averageSalary(employees));
        System.out.println();
        System.out.println();
        System.out.println("Ф.И.О. всех сотрудников:");
        printNames(employees);

    }

    private static void printAll(Employee[] employees) {
        for (Employee current : employees) {
            System.out.println(current);
        }
    }

    private static void printById(Employee[] employees, int id) {
        System.out.println(employees[id - 1]);
    }

    private static int summAll(Employee[] employees) {
        int summ = 0;
        for (Employee current : employees) {
            summ += current.getSalary();
        }
        return summ;
    }

    private static int minSalaryId(Employee[] employees) {
        int min = employees[0].getSalary();
        int minId = employees[0].getId();
        for (Employee current : employees) {
            if (min > current.getSalary()) {
                min = current.getSalary();
                minId = current.getId();
            }
        }
        return minId;
    }

    private static int maxSalaryId(Employee[] employees) {
        int max = employees[0].getSalary();
        int maxId = employees[0].getId();
        for (Employee current : employees) {
            if (max < current.getSalary()) {
                max = current.getSalary();
                maxId = current.getId();
            }
        }
        return maxId;
    }

    private static double averageSalary(Employee[] employees) {
        return (double) summAll(employees) / employees.length;
    }

    private static void printNames(Employee[] employees) {
        for (Employee current: employees) {
            System.out.println(current.getName());
        }
    }

    private static void fillEmployees(Employee[] employees) {
        String[] namesArr = {"Иван", "Павел", "Василий", "Петр", "Кирилл", "Александр", "Алексей", "Антон"};
        String[] middlenamesArr = {"Иванович", "Павлович", "Васильевич", "Петрович", "Кириллович", "Александрович", "Алексеевич", "Антонович"};
        String[] lastnamesArr = {"Иванов", "Павлов", "Васильев", "Петров", "Кириллов", "Александров", "Алексеев", "Антонов"};
        Random rand = new Random();
        StringBuilder currentName = new StringBuilder();
        for (int i = 0; i < employees.length; i++) {
            currentName.delete(0, currentName.length());
            currentName.append(lastnamesArr[rand.nextInt(lastnamesArr.length)])
                    .append(" ")
                    .append(namesArr[rand.nextInt(namesArr.length)])
                    .append(" ")
                    .append(middlenamesArr[rand.nextInt(middlenamesArr.length)]);
            employees[i] = new Employee(currentName.toString(),
                    rand.nextInt(5) + 1,
                    rand.nextInt(100000) + 50000);
        }
    }
}