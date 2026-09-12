import java.util.Scanner;

public class Task1_StringsPalindrome {

    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String input) {
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = reverseString(cleaned);
        return cleaned.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] testWords = {"радар", "hello", "А роза упала на лапу Азора", "Java"};

        System.out.println("=== Автоматическая проверка на тестовых строках ===");
        for (String word : testWords) {
            String reversed = reverseString(word);
            boolean palindrome = isPalindrome(word);
            System.out.printf("Строка: \"%s\"%n  Развёрнутая: \"%s\"%n  Палиндром: %s%n%n",
                    word, reversed, palindrome ? "да" : "нет");
        }

        System.out.println("=== Ваша проверка ===");
        System.out.print("Введите строку: ");
        if (scanner.hasNextLine()) {
            String userInput = scanner.nextLine();
            System.out.println("Развёрнутая строка: " + reverseString(userInput));
            System.out.println("Это палиндром: " + (isPalindrome(userInput) ? "да" : "нет"));
        }

        scanner.close();
    }
}
