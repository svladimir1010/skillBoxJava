import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MileListTreeSet {

    private static TreeSet<String> emailList = new TreeSet<>();
    private static final String VALID_MAIL = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    private static final Pattern PATTERN_ADD = Pattern.compile("^ADD\\s+(?<address>.+$)");
    private static final Pattern PATTERN_DEL = Pattern.compile("^DEL\\s+(?<address>.+$)");

    public void parseCommand(String inputString) {

        Matcher matcherAdd = PATTERN_ADD.matcher(inputString);
        Matcher matcherDel = PATTERN_DEL.matcher(inputString);

        if (inputString.equals("LIST")) showItems();

        else if (inputString.equals("QUIT")) System.exit(0);

        else if (matcherAdd.matches()) addMail(matcherAdd.group("address"));

        else if (matcherDel.matches()) delMail(matcherDel.group("address"));
    }

    private static void delMail(String mail) {
        if (!emailList.remove(mail)) System.out.println("Элмента в списке нет");

        else showItems();
    }


    private static void addMail(String mail) {
        if (isValidMail(mail)) {
            emailList.add(mail);
            showItems();
        } else System.out.println("Неверный ввод");
    }

    private static boolean isValidMail(String address) {
        return address.matches(VALID_MAIL);
    }

    private static void showItems() {
        if (emailList.isEmpty()) System.out.println("\nСписок пуст\n");

        else emailList.forEach(System.out::println);
    }

    public static void showHelp() {
        String help = "\nСписок доступных команд:\n" +
                "Вывести список -   LIST\n" +
                "Добавить mail -    ADD\n" +
                "Удалить -          DEL\n" +
                "Выйти -            QUIT\n";
        System.out.println(help);
    }

}
