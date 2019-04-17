package Exams.MidExamMarch;

import java.util.*;
import java.util.stream.Collectors;

public class SeizeTheFire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> fire = Arrays.stream(sc.nextLine().split("#"))
                .collect(Collectors.toList());
        int water = Integer.parseInt(sc.nextLine());
        double effort = 0;
        int totalFire = 0;
        List<Integer> cells = new ArrayList<>();

        for (int i = 0; i < fire.size(); i++) {
            String[] data = fire.get(i).split(" = ");
            int value = Integer.parseInt(data[1]);
            if (data[0].equals("High") && value >= 81 && value <= 125 && water >= value) {
                cells.add(value);
                water -= value;
                totalFire += value;
                effort += (value  * 0.25);
            }
            if (data[0].equals("Medium") && value >= 51 && value <= 80 && water >= value) {
                cells.add(value);
                water -= value;
                totalFire += value;
                effort += (value  * 0.25);
            }
            if (data[0].equals("Low")&& value >= 1 && value <= 50 && water >= value) {
                cells.add(value);
                water -= value;
                totalFire += value;
                effort += (value  * 0.25);
            }
        }
        System.out.println("Cells:");
        cells.stream().forEach(c -> System.out.println("- " + c));
        System.out.printf("Effort: %.2f%n",effort);
        System.out.printf("Total Fire: %d",totalFire);

    }
}
