package StringProcessingAndRegex.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String number = sc.nextLine();

        int multiplicator = Integer.parseInt(sc.nextLine());

        if (multiplicator == 0) {
            System.out.println(0);
        } else {
            int reminder = 0;
            List<Integer> total = new ArrayList<>();

            for (int i = number.length() - 1; i >= 0; i--) {
                int result = ((int) number.charAt(i) - '0') * multiplicator;
                result += reminder; // add reminder from last result to new result
                reminder = result / 10; // 12(1), 35(3), 55(5)
                total.add(result % 10);// 12(add:2), 35(add:5)
            }

            if (reminder != 0) {
                total.add(reminder);
            }
            for (int i = total.size() - 1; i >= 0; i--) {
                System.out.print(total.get(i));
            }
        }
    }
}
