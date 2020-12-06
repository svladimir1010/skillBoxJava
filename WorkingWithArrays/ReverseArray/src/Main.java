public class Main {
    public static void main(String[] args) {
        String tex = "Каждый охотник желает знать, где сидит фазан";
        String[] arr = tex.split(",?\\s+");
//        for(String text: arr) System.out.println(text);
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println("item:  " + i + " " + arr[i]);
        }
    }
}
