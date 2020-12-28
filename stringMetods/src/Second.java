public class Second {
    public static void compare(String text) {

        String numbers = text.replaceAll("[^0-9]", " ");
        System.out.println(numbers);
        String[] array = numbers.replaceAll("\\s+", " ").trim().split(" ");
        int number1 = Integer.parseInt(array[0]);
        int number2 = Integer.parseInt(array[1]);
        int number3 = Integer.parseInt(array[2]);

        int count = number1 + number2 + number3;

        System.out.println(count);
    }
}
