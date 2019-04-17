package StringProcessingAndRegex;

import java.util.*;

public class StudentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] data = sc.nextLine().split("[,\\s-]+");
        Double[] grades = new Double[3];
        for (int i = 1; i < data.length; i++) {
            grades[i - 1] = Double.parseDouble(data[i]);
        }
        System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|\n",
                "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");

        double average = (grades[0] + grades[1] + grades[2]) / 3;
        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
                data[0],
                grades[0], grades[1], grades[2],
                average);
    }
}
