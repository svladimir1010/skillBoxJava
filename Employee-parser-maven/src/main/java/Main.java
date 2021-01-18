import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String data = getDateFromFile("data/staff.json");
        System.out.println("data: " + data);
        try {

            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(data);
            System.out.println("array: " + array);

            for (Object item : array) {
                JSONObject jsonObject = (JSONObject) item;
                System.out.println(jsonObject.get("name"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private static String getDateFromFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                builder.append(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
