package Exams.MidExamMarch;

import java.util.*;

public class SpringVacationTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = Integer.parseInt(sc.nextLine());
        double budget = Double.parseDouble(sc.nextLine());
        int group = Integer.parseInt(sc.nextLine());
        double fuelPerKm = Double.parseDouble(sc.nextLine());
        double foodPerPerson = Double.parseDouble(sc.nextLine());
        double roomPricePerNight = Double.parseDouble(sc.nextLine());

        double foodExpenses = foodPerPerson * group * days;
        double totalHotelExpenses = roomPricePerNight * group * days;
        if (group > 10) {
            totalHotelExpenses -= (totalHotelExpenses * 0.25);
        }
        double expenses = foodExpenses + totalHotelExpenses;
        if (expenses > budget) {
            System.out.print("Not enough money to continue the trip. ");
            System.out.printf("You need %.2f$ more.", (expenses - budget));
            return;
        }
        for (int day = 1; day <= days; day++) {
            double distance = Double.parseDouble(sc.nextLine());
            double fuelConsumed = distance * fuelPerKm;
            expenses += fuelConsumed;

            if (day % 3 == 0 || day % 5 == 0) {
                expenses += (0.4 * expenses);
            }
            if (day % 7 == 0) {
                double withdraw = expenses / group;
                expenses -= withdraw;
            }

            if (expenses > budget) {
                System.out.print("Not enough money to continue the trip. ");
                System.out.printf("You need %.2f$ more.", (expenses - budget));
                return;
            }
        }

        System.out.printf("You have reached the destination. You have %.2f$ budget left.", Math.abs(budget - expenses));
    }
}
