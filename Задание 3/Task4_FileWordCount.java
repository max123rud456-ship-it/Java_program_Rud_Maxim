import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task4_FileWordCount {

    private static void createSampleFileIfMissing(String path) {
        java.io.File file = new java.io.File(path);
        if (file.exists()) {
            return;
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Привет, это тестовый файл для подсчёта строк, слов и символов.\n");
            writer.write("Вторая строка содержит ещё несколько слов для примера.\n");
            writer.write("А это третья, последняя строка файла.\n");
        } catch (IOException e) {
            System.out.println("Не удалось создать тестовый файл: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "sample.txt";
        createSampleFileIfMissing(filePath);

        int lineCount = 0;
        int wordCount = 0;
        long charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    wordCount += trimmed.split("\\s+").length;
                }
            }

            System.out.println("Файл: " + filePath);
            System.out.println("Количество строк: " + lineCount);
            System.out.println("Количество слов: " + wordCount);
            System.out.println("Количество символов (без переносов строк): " + charCount);

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
