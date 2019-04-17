package Exams;

import java.util.Scanner;

public class BakeryMasterclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double budget = Double.parseDouble(sc.nextLine());
        int students = Integer.parseInt(sc.nextLine());

        double priceFlour = Double.parseDouble(sc.nextLine());
        double priceEggs = Double.parseDouble(sc.nextLine());
        double priceApron = Double.parseDouble(sc.nextLine());

        int totalFlour = students - (students /5);
        int totalEggs = 10 * students;
        int aprons = (int)Math.ceil(students * 1.2);

        double total = priceFlour * totalFlour +
                priceEggs * totalEggs +
                priceApron * aprons;

        if (total <= budget)
            System.out.printf("Items purchased for %.2f$.", total);
        else
            System.out.printf("%.2f$ more needed", total - budget);

    }
}
