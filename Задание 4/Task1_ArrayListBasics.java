import java.util.ArrayList;

public class Task1_ArrayListBasics {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Москва");
        cities.add("Астана");
        cities.add("Алматы");
        cities.add("Париж");
        cities.add("Берлин");
        cities.add("Токио");

        System.out.println("Список до изменений: " + cities);
        System.out.println("Размер: " + cities.size());

        cities.remove(2);

        cities.add("Лондон");
        cities.add("Рим");

        System.out.println("Список после изменений: " + cities);
        System.out.println("Размер: " + cities.size());
        System.out.println("Первый элемент: " + cities.get(0));
        System.out.println("Последний элемент: " + cities.get(cities.size() - 1));
    }
}
