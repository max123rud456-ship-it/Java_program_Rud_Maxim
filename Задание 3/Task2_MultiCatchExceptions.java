public class Task2_MultiCatchExceptions {

    public static int processArray(int[] array, int index, int divisor) {
        return array[index] / divisor;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        int[][] testCases = {
                {2, 5},
                {10, 2},
                {1, 0},
                {-1, 3},
                {3, 4}
        };

        for (int[] test : testCases) {
            int index = test[0];
            int divisor = test[1];
            try {
                int result = processArray(numbers, index, divisor);
                System.out.printf("array[%d] / %d = %d%n", index, divisor, result);
            } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
                System.out.printf("Ошибка при index=%d, divisor=%d -> %s: %s%n",
                        index, divisor, e.getClass().getSimpleName(), e.getMessage());
            } finally {
                System.out.println("  (попытка обработана)");
            }
        }
    }
}
