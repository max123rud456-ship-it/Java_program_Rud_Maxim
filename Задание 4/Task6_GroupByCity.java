import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
    String name;
    String city;

    Student(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Task6_GroupByCity {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Алина", "Астана"),
                new Student("Борис", "Алматы"),
                new Student("Виктор", "Астана"),
                new Student("Галина", "Шымкент"),
                new Student("Дамир", "Алматы"),
                new Student("Ержан", "Астана")
        );

        Map<String, List<Student>> byCity = new HashMap<>();
        for (Student student : students) {
            byCity.computeIfAbsent(student.city, k -> new ArrayList<>()).add(student);
        }

        for (Map.Entry<String, List<Student>> entry : byCity.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
