import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class Loader {
    private static final String OUT_DATA_FORMAT = "Имя: %s, Телефон: %s";
    private static final String VALID_NUMBER = "(\\+?([0-9]?[0-9]?)\\s?((.?\\d{3}\\W?)\\s?\\d{3}.?\\d{2,3}.?\\d{1,2}))";
    private static final String VALID_NAME = "([a-zа-яёA-ZА-ЯЁ]+)";
    private static Map<String, String> phoneBook = new TreeMap<>();
    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
//        phoneBook = new TreeMap<>() {{
//            put("John", "0689012505");
//            put("Bob", "+38 (096) 213-84-05");
//        }};
        while (true) {
            System.out.println("Введите имя, номер или команду (LIST, EXIT): ");
            String text = reader.nextLine().trim();
            if ("EXIT".equalsIgnoreCase(text)) return;
            else if ("LIST".equalsIgnoreCase(text)) showList();
            else if (!text.isEmpty() && text.matches(VALID_NUMBER) && !findByPhoneNumber(text)) {
                addPhoneNumberToPhoneBook(text);
            } else if (!text.isEmpty() && text.matches(VALID_NAME) && !findByName(text)) {
                addNameToPhoneBook(text);
            }
        }
    }

    private static void addNameToPhoneBook(String name) {
        System.out.println("Данное имя в справочнике не найдено. Введите номер телефона чтобы внести его в справочник или QUIT:");
        String phoneNumber = reader.nextLine().trim();
        if (phoneNumber.equalsIgnoreCase("QUIT")) return;
        if (phoneNumber.matches(VALID_NUMBER)) phoneBook.put(phoneNumber, name);
        else {
            System.out.println("Это не похоже на номер телефона");
            return;
        }
    }

    private static boolean findByName(String name) {
        boolean find = false;
        for (Map.Entry<String, String> pair : phoneBook.entrySet()) {
            if (pair.getValue().equals(name)) {
                find = true;
                printData(pair.getKey(), pair.getValue());
            }
        }
        return find;
    }

    private static void addPhoneNumberToPhoneBook(String phoneNumber) {
        System.out.println("Данный номер в базе не найден. Введите имя чтобы внести его в справочник или \"QUIT\":");
        String name = reader.nextLine().trim();
        if (name.equalsIgnoreCase("QUIT")) return;
        if (name.matches(VALID_NAME)) phoneBook.put(phoneNumber, name);
        else {
            System.out.println("Это не похоже на имя");
            return;
        }
    }

    private static boolean findByPhoneNumber(String phoneNumber) {
        boolean find = phoneBook.containsKey(phoneNumber);
        if (find) {
            printData(phoneNumber);
        }
        return find;
    }

    private static void showList() {
        phoneBook.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach((m) -> printData(m.getKey(), m.getValue()));
    }

    private static void printData(String phoneNumber) {
        printData(phoneNumber, phoneBook.get(phoneNumber));
    }

    private static void printData(String phoneNumber, String name) {
        System.out.println(String.format(OUT_DATA_FORMAT, name, phoneNumber));
    }
}
 /* Научиться работать с коллекцией Map.

        1. Напишите программу, которая будет работать как телефонная книга:
        Если пишем новое имя, программа просит ввести номер телефона и запоминает его.
        Если новый номер телефона — просит ввести имя и также запоминает.
        Если вводим существующее имя или номер телефона, программа выводит всю информацию о контакте.
        При вводе команды LIST программа печатает в консоль список всех абонентов в алфавитном порядке с номерами.

        2. Определяйте имя и телефон с помощью регулярных выражений.

        3. Подумайте, что выбрать в качестве ключа и значения для Map, выберите лучший вариант по вашему мнению.
        Опишите, какие минусы и плюсы видите в вашем выборе.
        Критерии оценки
*/
