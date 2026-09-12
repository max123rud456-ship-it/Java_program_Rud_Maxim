import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Task2_RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(3, 5, 3, 8, 5, 1, 8));

        System.out.println("Исходный список: " + numbers);

        Set<Integer> uniqueSet = new LinkedHashSet<>();
        uniqueSet.addAll(numbers);

        List<Integer> uniqueList = new ArrayList<>(uniqueSet);

        System.out.println("Без дубликатов: " + uniqueList);
    }
}
