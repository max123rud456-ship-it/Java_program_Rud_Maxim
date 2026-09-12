import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task5_WordFrequency {
    public static void main(String[] args) {
        String text = "кот сидит на окне кот смотрит на птицу птица улетает кот остаётся";

        String[] words = text.split("\\s+");

        Map<String, Integer> frequency = new LinkedHashMap<>();
        for (String word : words) {
            frequency.merge(word, 1, Integer::sum);
        }

        Map<String, Integer> sorted = frequency.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new));

        System.out.println("Частота слов (по убыванию):");
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
