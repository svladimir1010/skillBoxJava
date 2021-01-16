import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

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
        //============================

        for (Employee employee : staff) {
            System.out.println(employee.toString());
        }
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