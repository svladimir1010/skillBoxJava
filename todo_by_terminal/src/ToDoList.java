import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToDoList {
    private static ArrayList<String> todoList;

    private static final Pattern PATTERN_ADD = Pattern.compile("^(ADD)\\s+([а-яa-zА-ЯA-Z+\\s+?]+)");
    private static final Pattern PATTERN_INSERT = Pattern.compile("^ADD\\s+(\\d+?)\\s+(.+)");
    private static final Pattern PATTERN_EDIT = Pattern.compile("^EDIT\\s+(\\d+?)(.+)");
    private static final Pattern PATTERN_DEL = Pattern.compile("^DELETE\\s+(\\d+?)$");

    ToDoList() {
        todoList = new ArrayList<>() {{
            add("Сделать кофе");
            add("Выгулять слона");
            add("Купить сахар");
            add("Полить кактус");
        }};
    }


    public void parseCommand(String inputStr) {
//        String command = inputStr;
        Matcher addMatcher = PATTERN_ADD.matcher(inputStr.trim());
        Matcher insertMatcher = PATTERN_INSERT.matcher(inputStr.trim());
        Matcher editMatcher = PATTERN_EDIT.matcher(inputStr.trim());
        Matcher delMatcher = PATTERN_DEL.matcher(inputStr.trim());
//код выхода
        if (inputStr.equals("QUIT")) System.exit(0);
//показать весь список
        else if (inputStr.equals("LIST")) showItems();
//добавить новое задание
        else if (addMatcher.matches()) addItem(todoList.size(), addMatcher.group(2));
//ADD todoItem by number
        else if (insertMatcher.matches()) addItem(Integer.parseInt(insertMatcher.group(1)), insertMatcher.group(2));
////изменение задачи по номеру
        else if (editMatcher.matches()) editItem(Integer.parseInt(editMatcher.group(1)), editMatcher.group(2));
////удаление задачи
        else if (delMatcher.matches()) delItem(Integer.parseInt(delMatcher.group(1)));
// иначе список команд
        else showItems();
    }

    //удалить задачу
    private void delItem(int itemIndex) {
        if (indexOk(itemIndex))
            todoList.remove(itemIndex);
            showItems();
    }

    //добавить задачу
    private void addItem(int itemIndex, String tex) {
        if (itemIndex > todoList.size())
            itemIndex = todoList.size();
            todoList.add(itemIndex, tex);
            showItems();
    }

   //изменение элемента
    private void editItem(int itemIndex, String tex) {
        if (indexOk(itemIndex))
            todoList.set(itemIndex, tex);
            showItems();
    }

    //определяем правильность номера - item
    private boolean indexOk(int itemIndex) {
        if (itemIndex > todoList.size() - 1) {
            System.out.println("\nНеправильный номер записи, должно быть от 0 до " + (todoList.size() - 1));
            return false;
        }
        return true;
    }

    //показываем список дел
    private static void showItems() {
        if (todoList.size() == 0) {
            System.out.println("\nСписок пуст\n");
            return;
        }
        for (String item : todoList) System.out.println(todoList.indexOf(item) + " - " + item);
    }
    public static void showHelp() {
        String helpText =
                "\nПросмотр списка: LIST\n" +
                        "Добавить запись: ADD\n" +
                        "Вставить запись: ADD номер записи\n" +
                        "Изменить запись: EDIT номер записи\n" +
                        "Удалить запись: DELETE номер записи\n" +
                        "Выйти: QUIT\n";
        System.out.println(helpText);
    }
}

//    Цель задания
//    Научиться работать со списком ArrayList.
//        Что нужно сделать
//        Разработайте список дел, который управляется командами в консоли. Команды: LIST, ADD, EDIT, DELETE.
//        Принцип работы команд:
//        LIST — выводит дела с их порядковыми номерами;
//        ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;
//        EDIT — заменяет дело с указанным номером;
//        DELETE — удаляет.

//    Примеры команд
//        LIST
//        ADD Какое-то дело
//        ADD 4 Какое-то дело на четвёртом месте
//        EDIT 3 Новое название дела
//        DELETE 7
//        Команды вводятся одной строкой пользователем в консоль.
