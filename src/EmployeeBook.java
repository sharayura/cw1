import java.util.Random;

public class EmployeeBook {
    private Employee[] employees;


    public EmployeeBook(int number) {
        employees = new Employee[number];
    }

    public void printLessThan(int sampleSalary) {
        for (Employee current : this.employees) {
            if (current != null && current.getSalary() < sampleSalary) {
                this.printById(current.getId());
            }
        }
    }

    public void printMoreThan(int sampleSalary) {
        for (Employee current : this.employees) {
            if (current != null && current.getSalary() >= sampleSalary) {
                this.printById(current.getId());
            }
        }
    }

    public void salaryIndex(int index) {
        if (index < 0) {
            System.out.println("Неверное значение индекса.");
            return;
        }
        for (Employee current : this.employees) {
            if (current != null) {
                int salary = current.getSalary();
                current.setSalary(salary + salary * index / 100);
            }
        }
    }

    public void printAll() {
        for (Employee current : this.employees) {
            if (current != null) {
                System.out.println(current);
            }
        }
    }

    public void printAllFromDepartment(int department) {
        for (Employee current : this.employees) {
            if (current != null && current.getDepartment() == department) {
                System.out.println("ID: " + current.getId() + ". Ф.И.О.: " + current.getName() + ". ЗП: " + current.getSalary());
            }
        }
    }

    //??????????????????????????
    public void printById(int id) {
        System.out.println("ID: " + employees[id - 1].getId() + ". Ф.И.О.: " + employees[id - 1].getName()
                + ". ЗП: " + employees[id - 1].getSalary());
    }

    public int summAllDepartment(int department) {
        int summ = 0;
        for (Employee current : this.employees) {
            if (current != null && current.getDepartment() == department) {
                summ += current.getSalary();
            }
        }
        return summ;
    }

    public int minSalaryIdDepartment(int department) {
        if (department <= 0 || department > 5) {
            throw new RuntimeException("Такого отдела нет");
        }
        int minId = 0;
        int min = 0;
        for (Employee current : this.employees) {
            if (current != null && current.getDepartment() == department) {
                min = current.getSalary();
                minId = current.getId();
                break;
            }
        }
        if (minId == 0) {
            throw new RuntimeException("В данном отделе нет сотрудников");
        }
        for (Employee current : this.employees) {
            if (current != null && current.getDepartment() == department && min > current.getSalary()) {
                min = current.getSalary();
                minId = current.getId();
            }
        }
        return minId;
    }

    public int maxSalaryIdDepartment(int department) {
        if (department <= 0 || department > 5) {
            throw new RuntimeException("Такого отдела нет");
        }
        int maxId = 0;
        int max = 0;
        for (Employee current : this.employees) {
            if (current != null && current.getDepartment() == department) {
                max = current.getSalary();
                maxId = current.getId();
                break;
            }
        }
        if (maxId == 0) {
            throw new RuntimeException("В данном отделе нет сотрудников");
        }
        for (Employee current : employees) {
            if (current != null && current.getDepartment() == department && max < current.getSalary()) {
                max = current.getSalary();
                maxId = current.getId();
            }
        }
        return maxId;
    }

    public double averageSalaryDepartment(int department) {
        int count = 0;
        int summ = 0;
        for (Employee current : this.employees) {
            if (current != null && current.getDepartment() == department) {
                summ += current.getSalary();
                count++;
            }
        }
        if (count == 0) {
            throw new RuntimeException("В отделе нет сотрудников");
        }
        return (double) summ / count;
    }

    public void salaryIndexDepartment(int department, int index) {

        if (index < 0) {
            System.out.println("Неверное значение индекса.");
            return;
        }
        if (department <= 0 || department > 5) {
            throw new RuntimeException("Такого отдела нет");
        }
        for (Employee current : this.employees) {
            if (current != null && current.getDepartment() == department) {
                int salary = current.getSalary();
                current.setSalary(salary + salary * index / 100);
            }
        }
    }


    public void fillEmployees(int number) {
        String[] namesArr = {"Иван", "Павел", "Василий", "Петр", "Кирилл", "Александр", "Алексей", "Антон" };
        String[] middlenamesArr = {"Иванович", "Павлович", "Васильевич", "Петрович", "Кириллович", "Александрович", "Алексеевич", "Антонович" };
        String[] lastnamesArr = {"Иванов", "Павлов", "Васильев", "Петров", "Кириллов", "Александров", "Алексеев", "Антонов" };
        Random rand = new Random();
        StringBuilder currentName = new StringBuilder();
        for (int i = 0; i < number; i++) {
            currentName.delete(0, currentName.length());
            currentName.append(lastnamesArr[rand.nextInt(lastnamesArr.length)])
                    .append(" ")
                    .append(namesArr[rand.nextInt(namesArr.length)])
                    .append(" ")
                    .append(middlenamesArr[rand.nextInt(middlenamesArr.length)]);
            this.employees[i] = new Employee(currentName.toString(),
                    rand.nextInt(5) + 1,
                    rand.nextInt(100000) + 50000);
        }
    }
}
