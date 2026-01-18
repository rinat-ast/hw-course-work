import java.util.Arrays;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private final static  Random RANDOM = new Random();
    private final static String[] NAMES = {"Александр", "Михаил", "Дмитрий", "Сергей", "Андрей",
            "Алексей", "Евгений", "Иван", "Владимир", "Николай"};
    private final static String[] SURNAMES = {"Иванов", "Петров", "Сидоров", "Смирнов", "Кузнецов",
            "Попов", "Васильев", "Волков", "Андреев", "Романов"};
    private final static String[] PATRONYMICS = {"Александрович", "Михайлович", "Дмитриевич", "Сергеевич",
            "Андреевич", "Алексеевич", "Евгеньевич", "Иванович", "Владимирович", "Николаевич"};

    private final static Employee[] EMPLOYEES = new Employee[10];


    public static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(0, NAMES.length)] + " " +
                    PATRONYMICS[RANDOM.nextInt(0, PATRONYMICS.length)];
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50, 450));
        }

    }

    public static void main(String[] args) {

        initEmployees();//Тут вызвали метод. Он скрафтил сотрудников.
        // Они в  Employee[] EMPLOYEES. т.е в массиве с Классом Employee

        EmployeeBook book = new EmployeeBook(EMPLOYEES);
        EMPLOYEES[4] = null;// проверка кода с null в массиве
        System.out.println("EMPLOYEES[4] = " + EMPLOYEES[4]);

        System.out.println(" ");
        book.print();

        System.out.println(" ");
        System.out.println("________среднее значение_______________");
        System.out.println("calculateAverageOfSalary() = " + book.calculateAverageOfSalary());
        System.out.println("=======================================");

//        System.out.println("empBook.calculateAverageOfSalary() = " + empBook.calculateAverageOfSalary());

        System.out.println(" ");
        System.out.println("_________налоги_________________________");
        book.calculateTax("PROGRESSIVE");
        System.out.println("=======================================");
//        empBook.calculateTax("PROGRESSIVE");


        System.out.println(" ");
        System.out.println(Arrays.toString(EMPLOYEES));
        book.changeSalary(3,5);
        System.out.println("______тут повысилась зарплата_____________");
        System.out.println(Arrays.toString(EMPLOYEES));

        System.out.println(" ");
        System.out.println("___поиск сотрудника с большей зарплатой__printShortInfo();_");
        book.findEmployee(2,100);

        System.out.println(" ");
        System.out.println("__поиск сотрудников с меньшей зарплатой___");
        book.findPoorEmployee(200,3);

        System.out.println(" ");
        System.out.println("______метод на сравнение сотрудников______");
        Employee  donald = new Employee("donald", 1, 40000);
        System.out.println("equalsEmployees(donald) = " + book.equalsEmployees(donald));
        System.out.println("equalsEmployees(EMPLOYEES[7]) = " + book.equalsEmployees(EMPLOYEES[2]));

        System.out.println(" ");
        System.out.println("__метод на добавление нового сотрудника__");
        System.out.println("addEmployee(donald) = " + book.addEmployee(donald));
        System.out.println(Arrays.toString(EMPLOYEES));// это для проверки добавления

        System.out.println(" ");
        System.out.println("---метод для получения сотрудника по id--");
        System.out.println("book.searchById(13) = " + book.searchById(13));
        System.out.println("book.searchById(1) = " + book.searchById(1));

    }
}