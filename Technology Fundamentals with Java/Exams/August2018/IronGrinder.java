package Exams.August2018;

import java.util.*;

public class IronGrinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> townsTime = new HashMap<>();
        Map<String, Integer> townsPassengers = new HashMap<>();

        String input = sc.nextLine();
        while (!input.equals("Slide rule")) {

            String[] data = input.split(":");
            String town = data[0];
            String[] data2 = data[1].split("->");

            if (data2[0].equals("ambush")){
                if (townsTime.containsKey(town)){
                    townsTime.put(town,0);
                    int ambushed = Integer.parseInt(data2[1]);
                    townsPassengers.put(town,townsPassengers.get(town) - ambushed);
                }
            }else{
                int time = Integer.parseInt(data2[0]);
                int passengers = Integer.parseInt(data2[1]);

                if (!townsTime.containsKey(town)){
                    townsTime.put(town,time);
                    townsPassengers.put(town,passengers);
                }else{
                    if (townsTime.get(town) > time || townsTime.get(town) == 0){
                        townsTime.put(town,time);
                    }
                    townsPassengers.put(town,townsPassengers.get(town) + passengers);
                }
            }
            input = sc.nextLine();
        }
        townsTime.entrySet().stream().sorted((a,b) -> {
            if (a.getValue().compareTo(b.getValue()) == 0){
                return a.getKey().compareTo(b.getKey());
            }
            return a.getValue().compareTo(b.getValue());
        }).forEach(e -> {
            if (e.getValue() != 0 && townsPassengers.get(e.getKey()) > 0) {
                System.out.printf("%s -> Time: %d -> Passengers: %d%n"
                        ,e.getKey(),e.getValue(),townsPassengers.get(e.getKey()));
            }
        });

    }
}
