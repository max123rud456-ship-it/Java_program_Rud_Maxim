public class Task2 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Developer("Иван", 80000, 10),
                new Manager("Сергей", 90000, 6),
                new Designer("Алина", 70000, 4)
        };

        double total = 0;
        for (Employee e : employees) {
            System.out.println(e);
            total += e.calculateSalary();
        }
        System.out.printf("%nОбщий фонд зарплаты: %.2f руб.%n", total);
    }
}

abstract class Employee {

    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("%-10s %-10s итоговая зарплата: %.2f руб.",
                getClass().getSimpleName(), name, calculateSalary());
    }
}

class Developer extends Employee {

    private static final double HOURLY_OVERTIME_RATE = 1500;
    private int overtimeHours;

    public Developer(String name, double salary, int overtimeHours) {
        super(name, salary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateSalary() {
        return salary + overtimeHours * HOURLY_OVERTIME_RATE;
    }
}

class Manager extends Employee {

    private static final double BONUS_PER_TEAM_MEMBER = 5000;
    private int teamSize;

    public Manager(String name, double salary, int teamSize) {
        super(name, salary);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateSalary() {
        return salary + teamSize * BONUS_PER_TEAM_MEMBER;
    }
}

class Designer extends Employee {

    private static final double BONUS_PER_PROJECT = 3000;
    private int projectsCompleted;

    public Designer(String name, double salary, int projectsCompleted) {
        super(name, salary);
        this.projectsCompleted = projectsCompleted;
    }

    @Override
    public double calculateSalary() {
        return salary + projectsCompleted * BONUS_PER_PROJECT;
    }
}
