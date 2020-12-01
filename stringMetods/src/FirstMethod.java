public class FirstMethod {

    public static void compare(String text) {
        int index1_1 = text.indexOf(' ', 14);
        int index1_2 = text.lastIndexOf(' ', 19);

        int index2_1 = text.indexOf(' ', 34);
        int index2_2 = text.indexOf(' ', 39);

        int index3_1 = text.indexOf(' ', 55);
        int index3_2 = text.indexOf(' ', 61);
        int sasha = Integer.parseInt(text.substring(index1_1, index1_2).trim());
        int pety = Integer.parseInt(text.substring(index2_1, index2_2).trim());
        int masha = Integer.parseInt(text.substring(index3_1, index3_2).trim());

        System.out.println("Всего сумма зарплат: " + (sasha + pety + masha));
    }
}
