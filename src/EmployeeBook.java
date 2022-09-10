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

    public void printById(int id) {
        for (Employee current: this.employees) {
            if (current != null && current.getId() == id) {
                System.out.println("ID: " + employees[id - 1].getId() + ". Ф.И.О.: " + employees[id - 1].getName()
                        + ". ЗП: " + employees[id - 1].getSalary());
            }
        }
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
            if (current != null && current.getDepartment() == department
                    && (minId == 0 || min > current.getSalary())) {
                min = current.getSalary();
                minId = current.getId();
            }
        }
        if (minId == 0) {
            throw new RuntimeException("В данном отделе нет сотрудников");
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
            if (current != null && current.getDepartment() == department
                    && (maxId == 0 || max < current.getSalary())) {
                max = current.getSalary();
                maxId = current.getId();
            }
        }
        if (maxId == 0) {
            throw new RuntimeException("В данном отделе нет сотрудников");
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

    public void addNewEmployee(String name, int department, int salary) {
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i] == null) {
                this.employees[i] = new Employee(name, department, salary);
                return;
            }
        }
        System.out.println("Нет места для нового сотрудника");
    }
    public void deleteEmployee(String name) {
        for (int i = 0; i < this.employees.length; i++) {
            if (employees[i] != null && employees[i].getName() == name) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("Сотрудник " + name + " не найден");
    }
    public void editEmployeeDepartment(String name, int department) {
        for (int i = 0; i < this.employees.length; i++) {
            if (employees[i] != null && employees[i].getName() == name) {
                employees[i].setDepartment(department);
                return;
            }
        }
        System.out.println("Сотрудник " + name + " не найден");
    }
    public void editEmployeeSalary(String name, int salary) {
        for (int i = 0; i < this.employees.length; i++) {
            if (employees[i] != null && employees[i].getName() == name) {
                employees[i].setSalary(salary);
                return;
            }
        }
        System.out.println("Сотрудник " + name + " не найден");
    }

    public void printAllDepartment() {
        StringBuilder str = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            for (Employee current : employees) {
                if (current != null && current.getDepartment() == i) {
                    if (count > 0) {
                        str.append(", ");
                    }
                    str.append(current.getName());
                    count ++;
                }
            }
            System.out.printf("В отделе %d сейчас %d человек: ", i, count);
            System.out.println(str);
            count = 0;
            str.delete(0, str.length());
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
