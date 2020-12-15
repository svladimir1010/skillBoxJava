import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MileListTreeSet.showHelp();
        MileListTreeSet addMail = new MileListTreeSet();
        Scanner scan = new Scanner(System.in);

        while (true) addMail.parseCommand(scan.nextLine());
    }
}

