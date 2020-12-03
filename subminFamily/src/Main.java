import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Пожалуйста введите ваши ФИО- ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();   //получаем данные

//     исключаем цифры и пробел в начале строки и отфильтр. три слова, первые два с пробелами
        Boolean in = str.matches("[^0-9\\s+]([а-яА-ЯёЁ]+\\s+){2}[а-яА-ЯёЁ]+$");
//     System.out.println(str.matches("[^0-9\\s][а-яА-ЯёЁ]+\\s[а-яА-ЯёЁ]+\\s[а-яА-ЯёЁ]+$"));      // рабочий regex
//     System.out.println(str.matches("[^0-9\\s]([а-яА-ЯёЁ]+\\s){2}[а-яА-ЯёЁ]+$"));       // рабочий   regex

        String[] array = str.split(" "); //делим строку по пробелам и выделяем массив длинной "3"

        if (in && array.length == 3) {
            System.out.println("Family: " + array[0] + "," + "\nName: " + array[1] + "," + "\nLast name: " + array[2] + ".");
        } else {
            System.out.println("You entered incorrect data");
        }
    }
}


