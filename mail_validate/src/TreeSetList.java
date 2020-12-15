import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreeSetList {

    private static TreeSet<String> emails;

//    private static  final String EMAIL_VALID =
//            Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

    private static final Pattern PATTERN_ADD_EMAIL =
            Pattern.compile("^ADD\\s+([A-Z0-9_.+-]+@[A-Z0-9-]+\\.[A-Z0-9-.]+)$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN_DEL =
            Pattern.compile("^DEL\\s+([A-Z0-9_.+-]+@[A-Z0-9-]+\\.[A-Z0-9-.]+)$", Pattern.CASE_INSENSITIVE);

    TreeSetList() {
        emails = new TreeSet<>() {{
            add("first@gmail.com");
            add("second@gmail.com");
            add("three@gmail.com");
            add("four@gmail.com");
            add("five@gmail.com");
            add("six@gmail.com");
        }};
    }

    public void parseCommand(String inputEmail) {
        Matcher addMatcher = PATTERN_ADD_EMAIL.matcher(inputEmail);
        Matcher delMatcher = PATTERN_DEL.matcher(inputEmail);

        if (inputEmail.equals("QUIT")) System.exit(0);

        else if (inputEmail.equals("LIST")) showEmails();

        else if (addMatcher.matches()) {

            addNextEmail(addMatcher.group(1));

        } else if (delMatcher.matches()) {

            removeItem(delMatcher.group(1));

        } else {
            System.out.println("Вы ввели неверный EMAIL адрес");
            showHelp();
        }
    }

    private void addNextEmail(String mail) {
        emails.add(mail);
        showEmails();
    }

    private void removeItem(String item) {
        emails.remove(item);
        showEmails();
    }

    private static void showEmails() {
        int id = 0;
        if (emails.size() == 0) {
            System.out.println("\nСписок пуст\n");
            return;
        }
        for (String item : emails) {
            id++;
            System.out.println(id + " - " + item);
        }
    }

    public static void showHelp() {
        String help =
                "\nСписок команд\n" +
                        "LIST\n" +
                        "ADD\n" +
                        "DEL\n" +
                        "QUIT\n";
        System.out.println(help);
    }
}
/*^[A-Z0-9_.+-]+@[A-Z0-9-]+\.[A-Z0-9-.]+$
^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$
        (^[A-Z]+)(@)[A-Z]+(.)[A-Z]*$*/
 /*   Научиться работать со множеством TreeSet.
      Что нужно сделать
      Напишите программу, в которой будет храниться перечень адресов электронной почты. Адреса можно
      добавлять через консоль командой ADD и печатать весь список командой LIST.
      Программа должна проверять корректность вводимых email’ов и печатать сообщение об ошибке при необходимости.
      Принцип работы команд
      LIST — выводит список электронных адресов.
      ADD — проверяет и, если формат адреса верный, добавляет в множество.

      Примеры команд
LIST
ADD hello@skillbox.ru
Команды вводятся одной строкой пользователем в консоль.
*/