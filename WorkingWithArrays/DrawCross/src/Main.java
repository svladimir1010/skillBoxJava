public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"  ", "X", "  ", "  ", "  ", "  ", "  ", "X"},
                {"\n  ", "  ", "X", "  ", "  ", "  ", "X", "   "},
                {"\n  ", "  ", "  ", "X", "  ", "X", "  ", "  ", "  "},
                {"\n  ", "  ", "  ", "  ", "X", "  ", "  ", "  ", "  "},
                {"\n  ", "  ", "  ", "X", "  ", "X", "  ", "  ", "  "},
                {"\n  ", "  ", "X", "  ", "  ", "  ", "X", "  ",},
                {"\n  ", "X", "  ", "  ", "  ", "  ", "  ", "X",}
        };
        for (String[] tex : arr) {
            for (int j = 0; j < tex.length; j++) {
                System.out.print(tex[j]);
            }
        }
    }
}

/*
    Создайте с помощью циклов двумерный массив строк. При его распечатке в консоли должен выводиться крестик из X:
*/
