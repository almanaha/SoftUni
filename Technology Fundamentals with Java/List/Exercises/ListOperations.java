package List.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line = sc.nextLine();

        while (!line.equals("End")){

            String[] tokens = line.split("\\s+");

            if (tokens[0].equals("Add")){
                numbers.add(Integer.parseInt(tokens[1]));
            }else if(tokens[0].equals("Insert")){
                int index = Integer.parseInt(tokens[2]);
                if (index >= 0 && index < numbers.size()){
                    numbers.add(index,Integer.parseInt(tokens[1]));
                }else{
                    System.out.println("Invalid index");
                }
            }else if (tokens[0].equals("Remove")){
                int index = Integer.parseInt(tokens[1]);
                if (index >= 0 && index < numbers.size()){
                    numbers.remove(Integer.parseInt(tokens[1]));
                }else{
                    System.out.println("Invalid index");
                }
            }else if (tokens[0].equals("Shift")){
                int count = Integer.parseInt(tokens[2]);
                count = count % numbers.size();
                if (tokens[1].equals("left")){
                    for (int i = 0; i < count; i++) {
                        numbers.add(numbers.get(0));
                        numbers.remove(0);
                    }
                }else {
                    for (int i = 0; i < count; i++) {
                        numbers.add(0,numbers.get(numbers.size() - 1));
                        numbers.remove(numbers.size() - 1);
                    }
                }
            }
            line = sc.nextLine();
        }
        numbers.forEach(e -> System.out.print(e + " "));
    }
}
