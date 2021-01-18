import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Вася Пипеткин", 95000, new Date());
//        employee.setName(null);
        System.out.println(employee);

    }
}
