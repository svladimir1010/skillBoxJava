import java.util.*;

public class Loader {
    private static ArrayList<String> vipCarNumList = new ArrayList<>();
    private static TreeSet<String> vipCarNumTree = new TreeSet<>();
    private static HashSet<String> vipCarNumHash = new HashSet<>();
    private static long[] time = new long[]{0, 0};
    private static int region = 199;
    private static String[] lettersOfCarNumber = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
    private static final String REGEX_CAR_NUM = "(A|B|E|K|M|H|O|P|C|T|Y|X)\\d{3}(A|B|E|K|M|H|O|P|C|T|Y|X){2}\\d{1,3}";
    private static Scanner inpNum = new Scanner(System.in);

    public static void main(String[] args) {
        generatorNumbers();
        while (true) {
            boolean result;
            System.out.println("Please enter car number like this \"A111BC197\", or command \"EXIT\": ");
            String str = inpNum.nextLine().trim();
            System.out.println(str);
            boolean findResult;

            if (!str.isEmpty() && str.equalsIgnoreCase("exit")) break;
            else if (!str.isEmpty() && !str.trim().matches(REGEX_CAR_NUM)) {
                System.out.println("You entered the WRONG number, try again.");
                continue;
            }

            time[0] = System.nanoTime();
            result = vipCarNumList.contains(str);
            time[1] = System.nanoTime();
            System.out.println("ArrayList(contains) = " + result + " number- " + str + " Time= " + (time[1] - time[0]));

            time[0] = System.nanoTime();
            result = vipCarNumList.indexOf(str) >= 0 ? true : false;
            time[1] = System.nanoTime();
            System.out.println("System.nanoTime(indexOf) = " + result + " number- " + str + " Time= " + (time[1] - time[0]));

            time[0] = System.nanoTime();
            result = Collections.binarySearch(vipCarNumList, str) >= 0 ? true : false;
            time[1] = System.nanoTime();
            System.out.println("Collections(binarySearch) = " + result + " number- " + str + " Time= " + (time[1] - time[0]));

            time[0] = System.nanoTime();
            result = vipCarNumTree.contains(str);
            time[1] = System.nanoTime();
            System.out.println("TreeSet(contains) = " + result + " number- " + str + " Time= " + (time[1] - time[0]));

            time[0] = System.nanoTime();
            result = vipCarNumHash.contains(str);
            time[1] = System.nanoTime();
            System.out.println("HashSet(contains) = " + result + " number- " + str + " Time= " + (time[1] - time[0]));
        }
    }

    private static void generatorNumbers() {
        for (int i = 1000; i > 0; i--) {
            String num = "";
            for (String letterOne : lettersOfCarNumber) {
                for (String letterTwo : lettersOfCarNumber) {
                    for (String letterThree : lettersOfCarNumber) {
                        long generRegion = Math.round(Math.random() * region) >= 1 ? Math.round(Math.random() * region) : 1;
                        vipCarNumList.add(letterOne + (Math.round(Math.random() * 999)) + letterTwo + letterThree + generRegion);
                        vipCarNumTree.add(letterOne + (Math.round(Math.random() * 999)) + letterTwo + letterThree + generRegion);
                        vipCarNumHash.add(letterOne + (Math.round(Math.random() * 999)) + letterTwo + letterThree + generRegion);

                    }
                }
            }
        }
    }
}

//    Научиться сортировать и искать элементы в коллекциях.
//        Что нужно сделать
//
//        1. Напишите генератор «красивых» автомобильных номеров и методы поиска элементов в коллекциях:
//        прямым перебором по ArrayList,
//        бинарным поиском по сортированному ArrayList,
//        поиском в HashSet,
//        поиском в TreeSet.
//
//        2. Измерьте и сравните длительность каждого метода поиска.
//        Формат вывода результатов поиска:
//        Поиск перебором: номер найден/не найден, поиск занял 34нс
//        Бинарный поиск: номер найден/не найден, поиск занял 34нс
//        Поиск в HashSet: номер найден/не найден, поиск занял 34нс
//        Поиск в TreeSet: номер найден/не найден, поиск занял 34нс
//
//        3. Напишите в форме ответа, какой поиск — самый быстрый, а какой — самый медленный.
//        В видео Поиск и сортировка неточно указана оценка результата работы метода бинарного поиска Collections.binarySearch(). Метод возвращает int, если возвращаемое значение больше или равно нулю — это означает, что элемент найден. Если возвращаемое значение int меньше нуля — элемент в коллекции не найден.
//        Рекомендации
//        Сортировка не входит в учёт времени для бинарного поиска.
//        Для детального сравнения методов поиска используйте время в наносекундах:
//        System.nanoTime()
//        Используйте правила генерации номеров для получения более 2 млн номеров:
//        XYZ — различные буквы, N — цифры, R — регион (от 01 до 199);
//        XNNNYZR — пример, A111BC197, Y777HC66,
//        таким образом, количество номер будет достаточно для оценки времени поиска даже в миллисекундах.
