import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private double averageGrade;

    private transient String sessionToken;

    public Student(String name, int age, double averageGrade, String sessionToken) {
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
        this.sessionToken = sessionToken;
    }

    @Override
    public String toString() {
        return String.format(
                "Student{name='%s', age=%d, averageGrade=%.2f, sessionToken=%s}",
                name, age, averageGrade, sessionToken);
    }
}

public class Task5_StudentSerialization {

    private static final String FILE_NAME = "student.ser";

    public static void main(String[] args) {
        Student original = new Student("Мария Петрова", 20, 4.75, "TOKEN-SECRET-12345");
        System.out.println("До сериализации: " + original);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(original);
            System.out.println("Объект успешно сериализован в файл " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Ошибка сериализации: " + e.getMessage());
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Student restored = (Student) in.readObject();
            System.out.println("После десериализации: " + restored);
            System.out.println("Обратите внимание: sessionToken стал null, " +
                    "так как поле было объявлено transient и не сохранялось.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
        }
    }
}
