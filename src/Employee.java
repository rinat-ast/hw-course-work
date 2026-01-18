import java.util.Objects;

public class Employee {

    private static int idGenerator = 1;

    private final int id;
    private final String fullName;
    private int department;
    private int salary;


    public Employee(String fullName, int department, int salary) {
        id = idGenerator++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this == null) {// если в массиве есть null
            return false;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee worker = (Employee) o;
        if (!Objects.equals(salary, worker.salary)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "Сотрудник: " + fullName + ". Работает в департаменте №" + department + ".  Зарплата: " + salary + " денег. id=" + id;
    }

    public  void printShortInfo() {
        System.out.println(fullName + ". Зарплата " + salary + " денег.");
    }
}