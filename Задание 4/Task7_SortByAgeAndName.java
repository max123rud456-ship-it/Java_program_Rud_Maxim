import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class StudentInfo {
    String name;
    int age;

    StudentInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}

public class Task7_SortByAgeAndName {
    public static void main(String[] args) {
        List<StudentInfo> students = new ArrayList<>(List.of(
                new StudentInfo("Борис", 22),
                new StudentInfo("Алина", 20),
                new StudentInfo("Виктор", 20),
                new StudentInfo("Галина", 22),
                new StudentInfo("Дамир", 19)
        ));

        System.out.println("До сортировки: " + students);

        students.sort(Comparator.comparing((StudentInfo s) -> s.age)
                .thenComparing(s -> s.name));

        System.out.println("После сортировки: " + students);
    }
}
