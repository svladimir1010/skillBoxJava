import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+" +
            "/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\+?\\w?[\\s|-]?\\(?(\\w{3})\\)?" +
            "[\\s|-]?(\\w{3})[\\s|-]?(\\w{2})[\\s|-]?(\\w{2})$");
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {

        String[] components = data.split("\\s+");

        String name = components[0] + " " + components[1];

        if (components.length != 4 || !isNumber(components[3]) || !isEmail(components[2])) {
            throw new IllegalArgumentException("Wrong format. Correct components[2]format: \n" +
                    "add Василий Петров " + "vasily.petrov@gmail.com +79215637722");
        }

        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        System.out.println("Hell");
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }

    public static boolean isNumber(String number) {
        Matcher numberMatch = PHONE_NUMBER_PATTERN.matcher(number);
        return numberMatch.find();
    }

    public static boolean isEmail(String email) {
        Matcher emailMatch = EMAIL_PATTERN.matcher(email);
        return emailMatch.find();
    }
}