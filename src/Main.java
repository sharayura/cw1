/**
 * Повышенная сложность
 */

import java.util.Random;

public class Main {
    private static Employee[] employees;

    public static void main(String[] args) {
        employees = new Employee[10];
        fillEmployees(employees);
        printAll(employees);
        System.out.println();
        salaryIndex(employees, 50);
        System.out.println("После индексации:");
        printAll(employees);
        System.out.println();

        Random randDep = new Random();
        int department = randDep.nextInt(5) + 1;

        System.out.print("Сотрудник из отдела " + department + " с минимальной зарплатой: ");
        printById(employees, minSalaryIdDepartment(employees, department));
        System.out.print("Сотрудник из отдела " + department + " с максимальной зарплатой: ");
        printById(employees, maxSalaryIdDepartment(employees, department));
        System.out.println("Месячные затраты по отделу " + department + ": " + summAllDepartment(employees, department));
        System.out.printf("Средняя зарплата сотрудников из %d отдела: %.2f", department, averageSalaryDepartment(employees, department));
        System.out.println();

        salaryIndexDepartment(employees, department, 30);
        System.out.println("После индексации:");
        printAllFromDepartment(employees, department);
        System.out.println();

        Random randSalary = new Random();
        int sampleSalary = randSalary.nextInt(10000) + 100000;
        System.out.println("Сотрудники с зарплатой меньше " + sampleSalary);
        printLessThan(employees, sampleSalary);
        System.out.println();
        System.out.println("Сотрудники с зарплатой больше " + sampleSalary);
        printMoreThan(employees, sampleSalary);

    }

    private static void printLessThan(Employee[] employees, int sampleSalary) {
        for (Employee current: employees) {
            if (current.getSalary() < sampleSalary) {
                printById(employees, current.getId());
            }
        }
    }

    private static void printMoreThan(Employee[] employees, int sampleSalary) {
        for (Employee current: employees) {
            if (current.getSalary() >= sampleSalary) {
                printById(employees, current.getId());
            }
        }
    }

    private static void salaryIndex(Employee[] employees, int index) {
        if (index < 0) {
            System.out.println("Неверное значение индекса.");
            return;
        }
        for (Employee current : employees) {
            int salary = current.getSalary();
            current.setSalary(salary + salary * index / 100);
        }
    }

    private static void printAll(Employee[] employees) {
        for (Employee current : employees) {
            System.out.println(current);
        }
    }

    private static void printAllFromDepartment(Employee[] employees, int department) {
        for (Employee current : employees) {
            if (current.getDepartment() == department) {
                System.out.println("ID: " + current.getId() + ". Ф.И.О.: " + current.getName() + ". ЗП: " + current.getSalary());
            }
        }
    }

    private static void printById(Employee[] employees, int id) {
        System.out.println("ID: " + employees[id - 1].getId() + ". Ф.И.О.: " + employees[id - 1].getName()
                + ". ЗП: " + employees[id - 1].getSalary());
    }

    private static int summAllDepartment(Employee[] employees, int department) {
        int summ = 0;
        for (Employee current : employees) {
            if (current.getDepartment() == department) {
                summ += current.getSalary();
            }
        }
        return summ;
    }

    private static int minSalaryIdDepartment(Employee[] employees, int department) {
        if (department <= 0 || department > 5) {
            throw new RuntimeException("Такого отдела нет");
        }
        int minId = 0;
        int min = 0;
        for (Employee current : employees) {
            if (current.getDepartment() == department) {
                min = current.getSalary();
                minId = current.getId();
                break;
            }
        }
        if (minId == 0) {
            throw new RuntimeException("В данном отделе нет сотрудников");
        }
        for (Employee current : employees) {
            if (current.getDepartment() == department && min > current.getSalary()) {
                min = current.getSalary();
                minId = current.getId();
            }
        }
        return minId;
    }

    private static int maxSalaryIdDepartment(Employee[] employees, int department) {
        if (department <= 0 || department > 5) {
            throw new RuntimeException("Такого отдела нет");
        }
        int maxId = 0;
        int max = 0;
        for (Employee current : employees) {
            if (current.getDepartment() == department) {
                max = current.getSalary();
                maxId = current.getId();
                break;
            }
        }
        if (maxId == 0) {
            throw new RuntimeException("В данном отделе нет сотрудников");
        }
        for (Employee current : employees) {
            if (current.getDepartment() == department && max < current.getSalary()) {
                max = current.getSalary();
                maxId = current.getId();
            }
        }
        return maxId;
    }

    private static double averageSalaryDepartment(Employee[] employees, int department) {
        int count = 0;
        int summ = 0;
        for (Employee current: employees) {
            if (current.getDepartment() == department) {
                summ += current.getSalary();
                count++;
            }
        }
            if (count == 0) {
                throw new RuntimeException("В отделе нет сотрудников");
            }
        return (double) summ / count;
    }
    private static void salaryIndexDepartment(Employee[] employees, int department, int index) {

        if (index < 0) {
            System.out.println("Неверное значение индекса.");
            return;
        }
        if (department <= 0 || department > 5) {
            throw new RuntimeException("Такого отдела нет");
        }
        for (Employee current : employees) {
            if (current.getDepartment() == department) {
            int salary = current.getSalary();
            current.setSalary(salary + salary * index / 100);
            }
        }
    }


    private static void fillEmployees(Employee[] employees) {
        String[] namesArr = {"Иван", "Павел", "Василий", "Петр", "Кирилл", "Александр", "Алексей", "Антон" };
        String[] middlenamesArr = {"Иванович", "Павлович", "Васильевич", "Петрович", "Кириллович", "Александрович", "Алексеевич", "Антонович" };
        String[] lastnamesArr = {"Иванов", "Павлов", "Васильев", "Петров", "Кириллов", "Александров", "Алексеев", "Антонов" };
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