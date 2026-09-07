/**
 * Задание 1 (Базовый уровень).
 * Класс Student с private-полями, геттерами и сеттерами (проверка возраста 16–100).
 * Иерархия Animal / Dog / Cat с переопределением makeSound().
 *
 * Запуск: javac Task1.java && java Task1
 */
public class Task1 {
    public static void main(String[] args) {
        System.out.println("=== Student ===");
        Student student = new Student("Алина", 19, "ИС-21");
        System.out.println(student);
        student.setAge(20);
        System.out.println("После смены возраста: " + student);

        try {
            student.setAge(150); // должно выбросить исключение
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Animal / Dog / Cat ===");
        Animal[] animals = { new Dog("Рекс"), new Cat("Мурка") };
        for (Animal a : animals) {
            a.makeSound(); // полиморфизм: каждый класс звучит по-своему
        }
    }
}

class Student {

    private String name;
    private int age;
    private String group;

    public Student(String name, int age, String group) {
        this.name = name;
        setAge(age); // используем сеттер, чтобы сразу применить проверку
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 16 || age > 100) {
            throw new IllegalArgumentException(
                    "Возраст студента должен быть в диапазоне от 16 до 100 лет, передано: " + age);
        }
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", group='" + group + "'}";
    }
}

abstract class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Поведение по умолчанию, которое переопределяют наследники
    public void makeSound() {
        System.out.println(name + " издаёт какой-то звук.");
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " лает: Гав-гав!");
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " мяукает: Мяу-мяу!");
    }
}
