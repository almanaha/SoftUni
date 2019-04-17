package Exams.MarchDemoMid2019;

import java.util.*;

public class CookingMaster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double budget = Double.parseDouble(sc.nextLine());
        int students = Integer.parseInt(sc.nextLine());
        double flourPrice = Double.parseDouble(sc.nextLine());
        double eggsPrice = Double.parseDouble(sc.nextLine());
        double apronPrice = Double.parseDouble(sc.nextLine());

        int freeFlour = students / 5;
        double totalAp = Math.ceil(students * 1.2);

        double a = apronPrice * totalAp;
        double eggs = eggsPrice * 10 * students;
        double flour = (students - freeFlour) * flourPrice;

        double total = a + eggs + flour;
        if (total <= budget){
            System.out.printf("Items purchased for %.2f$.",total);
        }else{
            System.out.printf("%.2f$ more needed.", total - budget);
        }
    }
}
