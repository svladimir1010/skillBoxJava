public class FilterNum {
    public static void filter() {

        GetNums numPhone = new GetNums();
        String str = numPhone.readConsole();

        str = str.replaceAll("[^0-9]", "");
        str = str.trim();
        String[] arr = str.split("");

        System.out.println("+" + arr[0] + " " + arr[1] + arr[2] + arr[3] + " " + arr[4] + arr[5] + arr[6] + "-" + arr[7] + arr[8] + "-" + arr[9] + arr[10]);
    }
}
