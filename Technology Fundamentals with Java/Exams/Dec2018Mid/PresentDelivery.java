package Exams.Dec2018Mid;

import java.util.*;
import java.util.stream.Collectors;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> houses = Arrays.stream(sc.nextLine().split("@"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int presents = 2;
        int santaIndex = 0;

        String input = sc.nextLine();
        while (!input.equals("Merry Xmas!")) {

            String[] data = input.split("\\s+");
            int jump = Integer.parseInt(data[1]);

            if (santaIndex + jump >= houses.size()) {
                santaIndex = (santaIndex + jump) % houses.size();
            } else {
                santaIndex += jump;
            }

            if (houses.get(santaIndex) == 0) {
                System.out.printf("House %s will have a Merry Christmas.%n", santaIndex);
            } else {
                houses.set(santaIndex, houses.get(santaIndex) - presents);
            }
            input = sc.nextLine();
        }

        int fail = (int) houses.stream().filter(h -> h != 0).count();
        System.out.printf("Santa's last position was %d.%n", santaIndex);
        if (fail > 0) {
            System.out.printf("Santa has failed %d houses.%n", fail);
        } else {
            System.out.println("Mission was successful.");
        }
    }
}
