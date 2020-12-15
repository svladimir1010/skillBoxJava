import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TreeSetList listMails = new TreeSetList();
        TreeSetList.showHelp();

        Scanner scan = new Scanner(System.in);
        while(true) {
            listMails.parseCommand(scan.nextLine());
        }
    }
}


