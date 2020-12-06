import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetDayOfBirthday {
    public static void getDay() {

        Calendar calendar = Calendar.getInstance();
        int yearNow = calendar.getWeekYear();
        
        calendar.set(Calendar.YEAR, 1977);
        calendar.set(Calendar.MONTH, Calendar.OCTOBER);
        calendar.set(Calendar.DAY_OF_MONTH, 10);
        int birdYear = calendar.getWeekYear();

        int allLiveYears = yearNow - birdYear;
        for (int i = 0; i <= allLiveYears; i++) {

            calendar.add(Calendar.YEAR, i);
            String day = new SimpleDateFormat("EEEE").format(calendar.getTime());
            System.out.println("* " + i + " " + day);

        }
    }
}
