package Exams.January2019;

import java.util.*;
import java.util.stream.Collectors;

public class SantasGifts {
    public static List<Integer> houses;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cmd = Integer.parseInt(sc.nextLine());
        houses = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int santaIndex = 0;
        int index = 0;

        for (int i = 0; i < cmd; i++) {
            String[] data = sc.nextLine().split("\\s+");
            String command = data[0];
            switch (command){
                case "Forward":
                    index = Integer.parseInt(data[1]);
                    if (index >= 0 && index < houses.size()) {
                        santaIndex += index;
                        houses.remove(santaIndex);
                    }
                    break;
                case "Back":
                    index = Integer.parseInt(data[1]);
                    santaIndex -= index;
                    if (santaIndex >= 0 && santaIndex < houses.size()) {
                        houses.remove(santaIndex);
                    }else {
                        santaIndex += index;
                    }
                    break;
                case "Gift":
                    index = Integer.parseInt(data[1]);
                    int value = Integer.parseInt(data[2]);
                    if (index >= 0 && index < houses.size()) {
                        santaIndex = index;
                        houses.add(index, value);
                    }
                    break;
                case "Swap":
                    int house1 = Integer.parseInt(data[1]);
                    int house2 = Integer.parseInt(data[2]);
                    if (houses.contains(house1) && houses.contains(house2)){
                        index = houses.indexOf(house1);
                        int index2 = houses.indexOf(house2);
                        houses.set(index, house2);
                        houses.set(index2, house1);
                    }
                    break;
            }
        }
        System.out.println("Position: " + santaIndex);
        for (int i = 0; i < houses.size(); i++) {
            if (i == houses.size() - 1){
                System.out.print(houses.get(i));
            }else{
                System.out.print(houses.get(i) + ", ");
            }
        }
    }
}
