import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ToDoList myToDoList = new ToDoList();
        ToDoList.showHelp();
        String command;
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            command = scanner.nextLine().trim();
            myToDoList.parseCommand(command);
        }
    }
}







