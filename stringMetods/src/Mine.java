/*
    Напишите код в проекте StringExperiments, который считает сумму
        заработка всех друзей (Васи, Пети и Маши).
        Используйте методы indexOf(), lastIndexOf(), substring() и trim().
*/

public class Mine {
    public static void main(String[] args) {
        String text = "Саша заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
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


