package List.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line = sc.nextLine();

        while (!line.equals("end")){

            String[] tokens = line.split("\\s+");

            String command = tokens[0];
            if (command.equals("Delete")){
                int element = Integer.parseInt(tokens[1]);

                while (numbers.contains(element)){
                    numbers.remove(Integer.valueOf(element));
                }
            }else{
                int element = Integer.parseInt(tokens[1]);
                int index = Integer.parseInt(tokens[2]);
                if (index < numbers.size()) {
                    numbers.add(index, element);
                }
            }

            line = sc.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
