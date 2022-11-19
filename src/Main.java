import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> buyList = new ArrayList<String>();

    public static void main(String args[]) {
        boolean flag = true;

        while (flag == true) {
            flag = createMenu();
        }
        System.out.println(("Работа программы завершена"));
    }

    //метод ввода инфы
    public static String input(String message) {
        System.out.println(message);
        String inputStr = sc.nextLine();
        return inputStr;
    }

    //метод создания меню
    public static boolean createMenu() {
        System.out.println("------------Список операций----------");
        System.out.println("Добавленеи покупок в корзину - 1");
        System.out.println("Удаление покупок из корзины - 2");
        System.out.println("Показать покупки в корзине - 3");
        System.out.println("Поиск -4");
        System.out.println("Выход-Q");
        String in = input("Введите номер операции:");
        int var = 0;
        if (in.equals("Q")) {
            return false;
        }
        try {
            var = Integer.parseInt(in);
        } catch (NumberFormatException exception) {
            System.out.println("Введены некорректные данные");
        }
        if (var < 1 || var > 5) {
            System.out.println("Операции с таким номером не существует");
        }
        switch (var) {
            case 1: {
                addBuy();
                break;
            }
            case 2: {
                delBuy();
                break;
            }
            case 3: {
                showBuy();
                break;
            }
            case 4: {
                findBuy();
                break;
            }
            case 5: {
                System.out.println("ЛУЧШАЯ РЫБА ЭТО КОЛБАСА!!! ");
                String pause=input("Нажмите ENTER, чтобы продолжить");
                break;
            }

        }
        return true;
    }

    //добавление покупок в корзину
    public static void addBuy() {
        while (true) {
            String in = input("Введите наименование покупки для добавки ее в корзину:\n Выход из операции-Q");
            if (in.equals("Q")) {
                break;
            }
            buyList.add(in);
            System.out.println("Покупок в корзине:" + buyList.size());
        }

    }

    //удаление покупок из корзины
    public static void delBuy() {
        while (true) {
            showBuy();
            int var = 0;
            String in = input("Введите наименование или номер покупки для удаления ее из корзины:\n Выход из операции-Q");
            try {
                var = Integer.parseInt(in);
                try {
                    buyList.remove(var - 1);
                } catch (IndexOutOfBoundsException exception) {
                    System.out.println("Нет товара с таким номером  в списке");
                }
            } catch (NumberFormatException exception) {
                if (in.equals("Q")) {
                    break;
                }
                if (!buyList.remove(in)) {
                    System.out.println("Такого товара нет в корзине");
                }
            }
            System.out.println("Покупок в корзине:" + buyList.size());
        }

    }

    //показ покупок в корзине
    public static void showBuy() {
        System.out.println("Список покупок в корзине:");
        for (int i = 0; i < buyList.size(); i++) {
            System.out.println(i + 1 + " " + buyList.get(i));
        }

    }

    public static void findBuy() {
        while (true) {
            showBuy();
            String in = input("Введите наименование для поиска:\n Выход из операции-Q");
            if (in.equals("Q")) {
                break;
            }
            String fstr = in.toLowerCase(Locale.ROOT);
            System.out.println("Найдено по запросу:");
            for (int i = 0; i < buyList.size(); i++) {
                boolean flag = (buyList.get(i).toLowerCase(Locale.ROOT)).contains(fstr);
                if (flag) {
                    System.out.println(i + 1 + " " + buyList.get(i));
                }
            }
            String pause=input("Нажмите ENTER, чтобы продолжить");
        }

    }

}






