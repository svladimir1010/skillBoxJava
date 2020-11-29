import java.util.Scanner;

public class Loading {
    private static final int BOX_COUNT = 27;       // MAX ящиков в одном контейнере
    private static final int CONTAIN_COUNT = 12;   // MAX контейнеров на одной машине


    public static void main(String[] args) {
        int count = readConsole();                     // получаем submit from terminal

        int countCar = ((count % 324) >= 0) ? count / 324 + 1 : count / 324;  // сколько всего машин

        int lastCarWeight;
        lastCarWeight = ((count % 324 / BOX_COUNT) >= 0) ? count % 324 / BOX_COUNT + 1 : CONTAIN_COUNT;  // контейнеров в последн. машине

        int allContainers;

        allContainers = ((count % BOX_COUNT) >= 0) ? count / BOX_COUNT + 1 : count / BOX_COUNT;   // всего контейнеров

        System.out.println("ALL C A R: " + countCar);
        System.out.println("A L L C O N T A INERS: " + allContainers);
        System.out.println("carLastWeight  /" + lastCarWeight);

        int lastContFit;
        lastContFit = ((count % BOX_COUNT) >= 0) ? count % BOX_COUNT : BOX_COUNT;    // ящиков в последнем контейнере
        System.out.println("lastContFit -  " + lastContFit);

        for (int i = 1; i <= countCar; i++) {
            if (i != countCar) {
                Car car = new Car(i, CONTAIN_COUNT, lastContFit);
                System.out.println("C A R - " + car.carName + " -lastCarWeight " + CONTAIN_COUNT);
            } else {
                int j = lastCarWeight;
                Car car = new Car(i, j, lastContFit);
            }
        }

    }

    //===================       get count
    public static int readConsole() {
        System.out.println("Введите натуральное число -");
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("Попробуйте еще");
            return -1;
        }
    }

    //===================     get car
    public static class Car {
        private Car(int i, int j, int countBox) {
            this.carName = "C A R- " + i;
            this.carContain = j;
            System.out.println("М А Ш И Н А: " + carName + " /  вмещает- " + carContain + "контейнеров");
            for (int k = 1; k <= j; k++) {

                if (j != CONTAIN_COUNT && k == j) {
                    createCont(k, countBox);
                } else {
                    createCont(k, BOX_COUNT);
                }
            }
        }

        public static void createCont(int i, int countBox) {
            Container container = new Container(i, countBox);
        }

        private String carName;
        private int carContain;
    }

    //==========================  get container
    public static class Container {
        private String contNum;

        public Container(int id, int countBox) {

            this.contNum = "C O N T A I N E R - " + id;
            System.out.println("hello " + this.contNum);
            for (int i = 1; i <= countBox; i++) {
                Box box = new Box(i);
                System.out.println("box: " + box.boxId);

            }

        }

    }

    //========================  get box
    public static class Box {
        private String boxId;

        public Box(int id) {
            this.boxId = "Box- " + id;
        }
    }

}

