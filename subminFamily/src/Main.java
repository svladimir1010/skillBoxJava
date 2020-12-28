import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Пожалуйста введите ваши ФИО- ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();   //получаем данные
        //     исключаем цифры и пробел в начале строки и отфильтр. три слова, первые два с пробелами
        Boolean in = str.matches("([а-яА-ЯёЁ]+\\s+){2}[а-яА-ЯёЁ]+$");
        //     делим строку по пробелам и выделяем массив длинной "3"
        String[] array = str.split(" ");

        if (in && array.length == 3) {
            System.out.println("Family: " + array[0] + "," + "\nName: " + array[1] + "," + "\nLast name: " + array[2] + ".");
        } else {
            System.out.println("You entered incorrect data");
        }
    }
}

//    Что нужно сделать
//        Напишите программу, которая на входе через консоль принимает фамилию, имя и отчество одной строкой
//        (например, «Иванов Сергей Петрович») и выводит фамилию, имя и отчество отдельно в формате:
//        Фамилия: Иванов Имя: Сергей Отчество: Петрович

