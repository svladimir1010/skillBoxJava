import javax.sound.sampled.Line;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try {
//==========================================
//           FileInputStream is = new FileInputStream("data/read_files.txt");
//           for(;;)
//           {
//               int code = is.read();
//               if(code < 0)
//               {
//                   break;
//               }
////               char ch = (char) code;
//               builder.append((char) code);
//===============================================

//            BufferedReader br =
//                    new BufferedReader(
//                            new FileReader("data/read_files.txt"));
//            for (; ; ) {
//                String line = br.readLine();
//                if (line == null) break;
//                builder.append(line + "\n");
//            }
//================================================

            byte[] lines = Files.readAllBytes(Paths.get("data/read_files.txt"));
//            lines.forEach(e -> builder.append(e ));

            for (byte in : lines) {
                builder.append((char) in);
            }

//     ============================================
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(builder.toString());
    }
}

