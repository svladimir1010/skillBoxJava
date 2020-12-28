/*
    Создайте массив типа float с температурами 30 пациентов (от 32 до 40 градусов).
        Напишите код, который выводит среднюю температуру по больнице и количество
        здоровых пациентов (с температурой от 36,2 до 36,9), а также температуры всех пациентов.
        Вынесите в константы условия задания:
        количество пациентов,
        минимальная и максимальная температура пациентов,
        минимальная и максимальная температура диапазона здоровых пациентов.
        Пример
        Температуры пациентов: 36.7 38.9 34.7Средняя температура: 36.76 Количество здоровых: 1
*/
public class Main {
    public static final int NUMBER_PATIENTS = 30;
    public static final double MIN_HEALTHY_TEMP = 36.2;
    public static final double MAX_HEALTHY_TEMP = 36.9;

    public static void main(String[] args) {

        double[] arr = new double[NUMBER_PATIENTS];
        int countHealthy = 0;
        double averageTemperature;
        double sumTemperatures = 0.0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 32 + Math.random() * 8;
            sumTemperatures += arr[i];
            if (arr[i] >= MIN_HEALTHY_TEMP && arr[i] <= MAX_HEALTHY_TEMP) {
                countHealthy++;
            }
        }
        averageTemperature = sumTemperatures / NUMBER_PATIENTS;
        int i = 0;
        for (double personTemperature : arr) {
            System.out.print("Temperature of every person  " + (1 + i++) + ")  " + personTemperature + "  ");
        }
        System.out.println("\nAverage temperature: " + averageTemperature);
        System.out.println("Count healthy person: " + countHealthy);
    }
}

