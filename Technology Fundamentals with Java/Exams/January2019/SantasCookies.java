package Exams.January2019;

import java.util.*;

public class SantasCookies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int batches = Integer.parseInt(sc.nextLine());
        int totalBoxes = 0;

        while (batches-- > 0){
            double flour = Double.parseDouble(sc.nextLine());
            double sugar = Double.parseDouble(sc.nextLine());
            double cacoa = Double.parseDouble(sc.nextLine());

            int flourCups = (int) (flour / 140.0);
            int sugarSpoon = (int) (sugar / 20.0);
            int cacoaSpoon = (int) (cacoa / 10.0);
            if (flourCups <= 0 || sugarSpoon <= 0 || cacoaSpoon <= 0) {
                System.out.println("Ingredients are not enough for a box of cookies.");
                continue;
            }

            int min = Math.min(flourCups, sugarSpoon);
            min = Math.min(min, cacoaSpoon);
            int cookiesPerBake = (int) Math.floor((170 * (double)min) / 25);
            int cookiesPerBox = cookiesPerBake / 5;

            totalBoxes+= cookiesPerBox;
            System.out.println("Boxes of cookies: " + totalBoxes);
        }
        System.out.println("Total boxes: " + totalBoxes);


    }
}
