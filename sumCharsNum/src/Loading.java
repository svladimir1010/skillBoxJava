public class Loading {
    public static void main(String[] args) {

        System.out.println(sumDigits(1731)); // сумма чисел между собой

    }

    public static Integer sumDigits(Integer x) {

        int s = 0;

        for (int i = 0; i < x.toString().length(); i++) {  // первод числа в строку и проход по каждому символу

            s += Integer.parseInt(String.valueOf(x.toString().charAt(i)));

        }

        return s;

    }
}
