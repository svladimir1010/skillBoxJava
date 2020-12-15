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

    /*Разработайте список дел, который управляется командами в консоли. Команды: LIST, ADD, EDIT, DELETE.
        Принцип работы команд:
        LIST — выводит дела с их порядковыми номерами;
        ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;
        EDIT — заменяет дело с указанным номером;
        DELETE — удаляет.*/

 /*   Примеры команд
        LIST
        ADD Какое-то дело
        ADD 4 Какое-то дело на четвёртом месте
        EDIT 3 Новое название дела
        DELETE 7
        Команды вводятся одной строкой пользователем в консоль.*/




