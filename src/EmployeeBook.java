import java.util.Arrays;

public class EmployeeBook {
    private static Employee[] EMPLOYEES = new Employee[10];

    public EmployeeBook(Employee[] array) {
        EMPLOYEES = array;
    }

    public String toString() {
        return Arrays.toString(EMPLOYEES);
    }

    // метод распечатки массивов класса Employee-----------------8.1
    public void print() {
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    // метод нахождения средних значений зарплат------------------8.2
    public double calculateAverageOfSalary() {
        int count = 0;
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {//тут есть вопрос!
                sum += employee.getSalary();
                count++;
            } else {
                break;
            }
        }
        return (double) sum / count;
    }

    // метод для расчёта налогов сотрудников--------------------8.3
    public void calculateTax(String taxMode) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                switch (taxMode) {
                    case "PROPORTIONAL":
                        System.out.println(employee.getFullName() + ". зарплата: " + employee.getSalary() + ", налог = " + employee.getSalary() * 13 / 100);
                        break;
                    case "PROGRESSIVE":
                        if (employee.getSalary() < 150) {
                            System.out.println(employee.getFullName() + ". зарплата: " + employee.getSalary() + ", налог = " + employee.getSalary() * 13 / 100);
                        } else if (employee.getSalary() < 350) {
                            System.out.println(employee.getFullName() + ". зарплата: " + employee.getSalary() + ", налог = " + employee.getSalary() * 17 / 100);
                        } else {
                            System.out.println(employee.getFullName() + ". зарплата: " + employee.getSalary() + ", налог = " + employee.getSalary() * 21 / 100);
                            break;
                        }
                    default:
                        System.out.println(taxMode + "Не корректный ввод: только PROPORTIONAL или PROGRESSIVE");
                        break;
                }
            }
        }
    }

    //Получить в качестве параметра номер отдела (1–5) и проиндексировать зарплату--------------8.4
    // всех сотрудников отдела на процент, который приходит в качестве параметра
    // (то есть вызвать изменение зарплаты у всех сотрудников на величину аргумента в процентах).
    public void changeSalary(int department, int volume) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * (100 + volume) / 100);
            }
        }
    }
    //Получить в качестве параметра номер отдела (1–5) и цифру зарплаты-------------------------8.5
    //и вывести первого сотрудника этого отдела с зарплатой больше указанной
    //вместе с порядковым номером в списке.

    public void findEmployee(int department, int salary) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() > salary) {
                employee.printShortInfo();
                System.out.println("id Сотрудника: " + employee.getId());
            }
        }
    }

    //  Получить в качестве параметра цифру зарплаты wage и число сотрудников employeeNumber
//  и вывести первые employeeNumber сотрудников с зарплатой меньше wage
    public void findPoorEmployee(int wage, int employeeNumber) {//----------------8.6
        int count = 0;//для подсчёта employeeNumber
        int arrCount = 0;//

        while (arrCount < EMPLOYEES.length - 1) {
            if (EMPLOYEES[arrCount] != null && EMPLOYEES[arrCount].getSalary() < wage) {
                System.out.println(EMPLOYEES[arrCount]);
                count++;
                arrCount++;
            }
            if (count == employeeNumber) {
                break;
            }
        }

    }

    //    Получить в качестве параметра объект сотрудника и вернуть boolean, есть ли такой------8.7
//    сотрудник в массиве с точки зрения бухгалтерского учета (по зарплате) или нет.
    public boolean equalsEmployees(Employee employeeFind) {

        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.equals(employeeFind)) {
                return true;
            }
        }
        return false;
    }

    //Добавьте метод наполнения EmployeeBook метод должен найти свободную --9
// ячейку в массиве и положить в нее данные нового сотрудника.
    public boolean addEmployee(Employee newEmployee) {
        boolean addOrNot = false;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] == null) {
                EMPLOYEES[i] = newEmployee;
                addOrNot = true;
                break;
            }
        }
        return addOrNot;
    }

    //Добавьте метод для получения сотрудника по id
    public Employee searchById(int id) {
        Employee worker = null;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getId() == id) {
                worker = employee;
            }
        }
        return worker;
    }
}