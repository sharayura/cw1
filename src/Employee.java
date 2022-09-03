public class Employee {
    private final String name;
    private int salary;
    private int department;
    private final int id;
    static int idCount = 1;


    public Employee(String name, int department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        id = idCount++;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }
    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public void setDepartment(int department) {
        if (department > 0 && department <= 5) {
            this.department = department;
        }
    }

    @Override
    public String toString() {
        return id + ". " + name + " из " + department + "-го отдела. Зарплата " + salary;
    }
}
