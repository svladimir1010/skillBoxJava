import java.util.Scanner;

public class GetNums {
    public static String readConsole() {
        System.out.println("Enter your phone number-");
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextLine();
        } catch (Exception e) {
            System.out.println("Попробуйте еще");
            return "";
        }
    }


}
