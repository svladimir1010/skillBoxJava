import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";


    public static void main(String[] args) throws ParseException {
        String beginningOfPeriod = "01.01.2017";
        String endOfPeriod = "01.01.2018";

        Date date1 = new SimpleDateFormat(dateFormat).parse(beginningOfPeriod);
        Date date2 = new SimpleDateFormat(dateFormat).parse(endOfPeriod);

        ArrayList<Employee> staff = loadStaffFromFile();
        staff.forEach(System.out::println);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<AFTER>>>>>>>>>>>>>>>>>>>>>>>>");
        staff.stream().filter(e -> e.getWorkStart()
                .after(date1) & e.getWorkStart()
                .before(date2)).max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);
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

//Задание №1
//    Что нужно сделать
//        Выведите в консоль с помощью Stream API сотрудника
//        с максимальной зарплатой среди тех, кто пришёл в 2017 году.
//        Критерии оценки
//        «Зачёт» — в консоль выведен сотрудник и его
//        зарплата «Незачёт» — задание не выполнено.
//
//        Задание №2
//        Что нужно сделать
//        Распечатайте с помощью библиотеки airport.jar время вылета
//        и модели самолётов, вылетающих в ближайшие два часа.
