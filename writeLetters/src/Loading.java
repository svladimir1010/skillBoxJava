import org.w3c.dom.ls.LSOutput;

public class Loading {
    public static void main(String[] args) {
        String som = "Aa Bb Cc Dd Ee Ff Gg Hh Ii Jj Kk Ll Mm Nn Oo Pp Qq Rr Ss Tt Uu Vv Ww Xx Yy Zz";

        som = som.replaceAll("\\s+", "");
        System.out.println(som + "/----/" + som.length());
        for (int i = 0; i <= som.length(); i++) {
            System.out.println((int) som.charAt(i));

        }
    }

}