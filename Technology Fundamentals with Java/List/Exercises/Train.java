package List.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int wagonCapacity = Integer.parseInt(sc.nextLine());

        String cmd = sc.nextLine();

        while (!cmd.equals("end")){
            String[] commands = cmd.split(" ");

            if (commands[0].equals("Add")){
                int newWagon = Integer.parseInt(commands[1]);
                wagons.add(newWagon);
            }else{
                int passengers = Integer.parseInt(commands[0]);
                wagons.stream().filter(w -> wagonCapacity - w >= passengers)
                        .findFirst()
                        .ifPresent(freeWagon -> {
                            int indexOfFreeWagon = wagons.indexOf(freeWagon);
                            wagons.set(indexOfFreeWagon, freeWagon + passengers);
                        });
            }
            cmd = sc.nextLine();
        }
        wagons.forEach(w -> System.out.print(w + " "));
    }
}
