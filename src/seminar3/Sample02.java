package seminar3;

import java.util.*;

public class Sample02 {

    /**
     * 1. Доработать класс Freelancer, при желании можно разработать и свой собтственный тип сотрудника.
     * 2. Переработать метод generateEmployee, метод должен создавать случайного сотрудника (Worker, Freelancer или любого другого).
     * Метод должен быть один!
     * 3. Придумать свой собственный компаратор (Возможно отсортировать сотрудников по возрасту?
     * Тогда добавьте соответствующее состояние на уровне ваших классов).
     * 4. Продемонстрировать сортировку объектов различного типа с использованием собственного компаратора.
     */

    private static Random random = new Random();

    /**
     * TODO: 2. Переработать метод generateEmployee(). Метод должен возвращать
     * любого случайного сотрудника разного типа (Worker, Freelancer)
     *
     * @return
     */

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = generateEmployee();
        }
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        Arrays.sort(employees);
        System.out.println("\n*** Отсортированный массив сотрудников ***\n");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        Arrays.sort(employees, new AgeComparator());
        System.out.println("\n*** Отсортированный массив сотрудников по возрасту ***\n");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees, new PositionComparator());
        System.out.println("\n*** Отсортированный массив сотрудников по должности ***\n");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static Employee generateEmployee() {
        String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман"};
        String[] surnames = new String[]{"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов"};
        int salary = random.nextInt(900, 1500);
        int age = random.nextInt(20, 60);
        int salaryIndex = random.nextInt(28, 31);
        return switch (random.nextInt(3)) {
            case 0 -> new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)], "Рабочий", salary * salaryIndex, age);
            case 1 -> new Freelancer(names[random.nextInt(10)], surnames[random.nextInt(10)], "Фрилансер", salary, age, random.nextInt(1, 8), random.nextInt(1, 28));
            case 2 -> new Manager(names[random.nextInt(10)], surnames[random.nextInt(10)],"Менеджер", salary * salaryIndex, age, random.nextInt(3, 10));
            default -> null;
        };
    }
}

class SalaryComparator implements Comparator<Employee> {
    // 1 0 -1
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o2.calculateSalary(), o1.calculateSalary());
        //return o1.calculateSalary() == o2.calculateSalary() ? 0 :
        //        (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
    }
}

class FirstNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.firstName.compareTo(o2.firstName);
    }
}

class SurNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.surName.compareTo(o2.surName);
    }
}

class AgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
class PositionComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.position.compareTo(o2.position);
    }
}

abstract class Employee implements Comparable<Employee> {
    protected String firstName;
    protected String surName;
    protected int age;
    protected String position;
    protected double salary;
    protected int numOfSubordinates;

    public Employee(String firstName, String surName, String position, double salary, int age) {
        this.firstName = firstName;
        this.surName = surName;
        this.position = position;
        this.salary = salary;
        this.age = age;
        this.numOfSubordinates = 0;
    }

    public abstract double calculateSalary();

    public int getAge(){
        return age;
    }

    public String getPosition(){
        return position;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Ставка: %.2f; Возраст %d; Среднемесячная заработная плата: %.2f",
                surName, firstName, salary, age, calculateSalary());
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculateSalary(), o.calculateSalary());
    }
}

class Worker extends Employee {
    public Worker(String firstName, String surName, String position, double salary, int age) {
        super(firstName, surName, position, salary, age);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; %s; Возраст: %d; Среднемесячная заработная плата: %.2f",
                surName, firstName, position, age, calculateSalary());
    }
}

/**
 * TODO: 1. Разработать самостоятельно в рамках домашней работы.
 */
class Freelancer extends Employee {
    // salary * 18 * 5
    private final int hoursPerDay;
    private final int daysWorked;

    public Freelancer(String firstName, String surName, String position, double salary, int age, int hoursPerDay, int daysWorked) {
        super(firstName, surName, position, salary, age);
        this.hoursPerDay = hoursPerDay;
        this.daysWorked = daysWorked;
    }

    @Override
    public double calculateSalary() {
        return salary * hoursPerDay * daysWorked;
    }

    @Override
    public String toString() {
        return String.format("%s %s; %s; Возраст %d; Среднемесячная заработная плата: %.2f",
                surName, firstName, position, age, calculateSalary());
    }
}

class Manager extends Employee {
    private final int numOfSubordinates;

    public Manager(String firstName, String surName, String position, double salary, int age, int numOfSubordinates) {
        super(firstName, surName, position, salary, age);
        this.numOfSubordinates = numOfSubordinates;
    }

    public int getNumOfSubordinates() {
        return numOfSubordinates;
    }

    @Override
    public double calculateSalary() {
        return salary * numOfSubordinates;
    }

    @Override
    public String toString() {
        return String.format("%s %s; %s; Возраст %d; Количество сотрудников %d; Среднемесячная заработная плата: %.2f",
                surName, firstName, position, age, numOfSubordinates, calculateSalary());
    }
}

