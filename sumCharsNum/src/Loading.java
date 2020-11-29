import java.util.Scanner;

public class Loading {
    public static void main(String[] args) {
        System.out.println(sumDigits(readConsole())); // сумма чисел между собой
    }

    public static Integer sumDigits(Integer x) {
        int s = 0;
        for (int i = 0; i < x.toString().length(); i++) {  // первод числа в строку и проход по каждому символу
            s += Integer.parseInt(String.valueOf(x.toString().charAt(i)));
        }
        return s;
    }

    public static int readConsole() {
        System.out.println("Введите натуральное число -");
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("Попробуйте еще");
            return -1;
        }
    }
}
