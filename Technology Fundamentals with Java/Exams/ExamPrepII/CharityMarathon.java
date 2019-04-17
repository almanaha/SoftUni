package Exams.ExamPrepII;

import java.util.*;

public class CharityMarathon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = Integer.parseInt(sc.nextLine());
        int runners = Integer.parseInt(sc.nextLine());
        int avgLaps = Integer.parseInt(sc.nextLine()); // per runner
        int length = Integer.parseInt(sc.nextLine()); // in meters / 1000 --> KM
        int capacity = Integer.parseInt(sc.nextLine());
        double moneyPerKm = Double.parseDouble(sc.nextLine());

        if (runners > capacity * days){
            runners = capacity * days;
        }
        double totalMeters = length * runners * avgLaps;
        double kilometers = totalMeters / 1000;
        double totalMoney = kilometers * moneyPerKm;

        System.out.printf("Money raised: %.2f%n",totalMoney);
    }
}
