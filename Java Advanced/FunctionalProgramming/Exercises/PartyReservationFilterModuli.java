package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.Predicate;

public class PartyReservationFilterModuli {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Map<String, Predicate<String>> predicatesMap = new HashMap<>();
        String[] people = sc.nextLine().split("\\s+");

        String command;
        while (!"Print".equals(command = sc.nextLine())){
            String[] data = command.substring(command.indexOf(";") + 1).split(";");
            String name = data[0] + data[1];

            if (command.contains("Add")){
                Predicate<String> predicate = null;
                switch (data[0]){
                    case "Starts with":
                        predicate = e -> e.startsWith(data[1]); break;
                    case "Ends with":
                        predicate = e -> e.endsWith(data[1]); break;
                    case "Length":
                        predicate = e -> e.length() == Integer.parseInt(data[1]); break;
                    case "Contains":
                        predicate = e -> e.contains(data[1]); break;
                }
                predicatesMap.putIfAbsent(name,predicate);
            }else {
                predicatesMap.remove(name);
            }
        }
        for (String name : people) {
            boolean isValid = true;
            for (String predicateName : predicatesMap.keySet()) {
                if (predicatesMap.get(predicateName).test(name)){
                    isValid = false;
                    break;
                }
            }
            if (isValid){
                System.out.print(name + " ");
            }
        }
    }
}
