package List;

import java.util.*;
import java.util.stream.Collectors;

public class ListManipulatorAdvanced {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String line = sc.nextLine();
        while (!line.equals("end")) {
            String[] tokens = line.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    int element = Integer.parseInt(tokens[1]);
                    if (nums.contains(element)) System.out.print("Yes");
                    else System.out.print("No such number");
                    break;
                case "Print":
                    String parity = tokens[1];
                    if (parity.equals("even")) {
                        nums.stream().filter(n -> n % 2 == 0).forEach(e -> System.out.print(e + " "));
                    } else {
                        nums.stream().filter(n -> n % 2 == 1).forEach(e -> System.out.print(e + " "));
                    }
                    break;
                case "Get":
                    System.out.print(nums.stream().reduce((e1, e2) -> e1 + e2).get());
                    break;
                case "Filter":
                    String condition = tokens[1];
                    int number = Integer.parseInt(tokens[2]);
                    if (condition.equals("<")) {
                        nums.stream().filter(e -> e < number)
                                .forEach(e -> System.out.print(e + " "));
                    } else if (condition.equals(">")) {
                        nums.stream().filter(e -> e > number)
                                .forEach(e -> System.out.print(e + " "));
                    } else if (condition.equals(">=")) {
                        nums.stream().filter(e -> e >= number)
                                .forEach(e -> System.out.print(e + " "));
                    } else {
                        nums.stream().filter(e -> e <= number)
                                .forEach(e -> System.out.print(e + " "));
                    }
            }
            System.out.println();
            line = sc.nextLine();
        }
    }
}
