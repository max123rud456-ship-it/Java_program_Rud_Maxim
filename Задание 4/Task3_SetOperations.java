import java.util.HashSet;
import java.util.Set;

public class Task3_SetOperations {
    public static void main(String[] args) {
        Set<String> courseA = new HashSet<>(Set.of("Алина", "Борис", "Виктор", "Галина", "Дамир"));
        Set<String> courseB = new HashSet<>(Set.of("Борис", "Галина", "Ержан", "Жанна"));

        System.out.println("Курс А: " + courseA);
        System.out.println("Курс Б: " + courseB);

        Set<String> intersection = new HashSet<>(courseA);
        intersection.retainAll(courseB);
        System.out.println("Пересечение (оба курса): " + intersection);

        Set<String> union = new HashSet<>(courseA);
        union.addAll(courseB);
        System.out.println("Объединение (хотя бы один курс): " + union);

        Set<String> onlyA = new HashSet<>(courseA);
        onlyA.removeAll(courseB);
        System.out.println("Только на курсе А: " + onlyA);

        System.out.println("Исходный курс А не изменился: " + courseA);
        System.out.println("Исходный курс Б не изменился: " + courseB);
    }
}
