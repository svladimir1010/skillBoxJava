import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) {
        ArrayList<Employee> staff = loadStaffFromFile();
        //============================ одновременное сравнение по двум параметрам с "Lambda" и "Comparator.comparing"

        Collections.sort(staff, Comparator.<Employee>comparingInt(o1 -> o1.getSalary())
                .thenComparing(o2 -> o2.getName())
        );
        // ==========================  одновременное сравнение по двум параметрам  with  only  "Comparator.comparing"

//        Collections.sort(staff, Comparator.comparing(Employee::getSalary)
//                .thenComparing(Employee::getName));
        //============================  метод sorted by stream()

//        staff.stream().sorted(Comparator.comparing(Employee::getSalary))
//                .forEach(System.out::println);

        //=============================   получение максимального значения (работник с наибольшей зарпл) с помощью  STREAM max

//        staff.stream().max(Comparator.comparing(Employee::getSalary))
//                .ifPresent(System.out::println);

        //  ===========================  методы MAP() и REDUCE() by STREAM()

        staff.stream()
                .map(e -> e.getSalary())
                .filter(s -> s >= 100000)
                .reduce((s1, s2) -> s1 + s2).ifPresent(System.out::println);


        //  ===========================

//        for (Employee employee : staff) {
//            System.out.println(employee.toString());
//        }
        //============================  =============================    example with using forEach

        System.out.println("BEFORE");
        staff.forEach(System.out::println);

        System.out.println("AFTER");
        int salaryIncrease = 10000;
        staff.forEach(e -> e.setSalary(e.getSalary() + salaryIncrease));
        staff.forEach(System.out::println);

        System.out.println("EVEN AFTER");

        // ===================                     вызов STREAM из коллекции

        Stream<Employee> stream = staff.stream();

        stream.filter(e -> e.getSalary() >= 100000)
                .forEach(System.out::println);
//================================= выводим четные числа

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.filter(e -> e % 2 == 0).forEach(System.out::println);

        //=========================
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 100};
        Arrays.stream(nums).forEach(e -> System.out.println(e));

        //=============================   бесконечный Stream

        Stream.iterate(1, n -> n + 1).forEach(System.out::println);

        //=============================   бесконечный Stream

        Stream.generate(() -> "YYYYYY").forEach(System.out::println);

    }

    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> staff = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for (String line : lines) {
                String[] fragments = line.split("\t");
                if (fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }

                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}