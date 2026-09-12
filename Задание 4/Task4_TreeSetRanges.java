import java.util.Random;
import java.util.TreeSet;

public class Task4_TreeSetRanges {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        Random random = new Random();

        while (numbers.size() < 10) {
            numbers.add(random.nextInt(100) + 1);
        }

        System.out.println("Все числа: " + numbers);
        System.out.println("Первый элемент: " + numbers.first());
        System.out.println("Последний элемент: " + numbers.last());
        System.out.println("Числа меньше 50: " + numbers.headSet(50));
        System.out.println("Числа от 20 до 80: " + numbers.subSet(20, 80));
    }
}
