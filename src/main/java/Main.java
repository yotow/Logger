import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        int count;
        int upperLimit;
        int treshhold;

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка:"); //7
        count = scanner.nextInt();

        System.out.println("Введите верхнюю границу для значений:"); //10
        upperLimit = scanner.nextInt();

        logger.log("Создаём и наполняем список");
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(upperLimit));
        }

        System.out.println("Вот случайный список:");
        list.forEach(x -> System.out.print(x + " "));
        System.out.println();

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра:");
        treshhold = scanner.nextInt();

        Filter filter = new Filter(treshhold);
        List<Integer> newList = filter.filterOut(list);

        logger.log("Прошло фильтр " + newList.size() + " элемента из " + count);

        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список:");
        newList.forEach(x -> System.out.print(x + " "));
        System.out.println();
        logger.log("Завершаем программу");
    }
}
