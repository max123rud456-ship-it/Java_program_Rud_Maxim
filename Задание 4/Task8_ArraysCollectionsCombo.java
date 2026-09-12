import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Task8_ArraysCollectionsCombo {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }

        System.out.println("Исходный массив: " + Arrays.toString(array));

        List<Integer> list = new ArrayList<>();
        for (int value : array) {
            list.add(value);
        }

        Collections.sort(list);
        System.out.println("Отсортированный список: " + list);

        int index = Collections.binarySearch(list, 42);
        if (index >= 0) {
            System.out.println("Число 42 найдено по индексу: " + index);
        } else {
            System.out.println("Число 42 не найдено в списке");
        }

        int max = Collections.max(list);
        int min = Collections.min(list);
        int sum = list.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Максимум: " + max);
        System.out.println("Минимум: " + min);
        System.out.println("Сумма: " + sum);
    }
}
