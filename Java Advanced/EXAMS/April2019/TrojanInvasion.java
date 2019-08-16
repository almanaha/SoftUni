package EXAMS.April2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class TrojanInvasion {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int waves = Integer.parseInt(sc.readLine());

        Deque<Integer> spartans = new ArrayDeque<>();
        Deque<Integer> plates = new ArrayDeque<>();
                Arrays.stream(sc.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(plates::offer);

        for (int i = 1; i <= waves; i++) {
            Arrays.stream(sc.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .forEach(spartans::push);

            if (i % 3 == 0) {
                int extraPlate = Integer.parseInt(sc.readLine());
                plates.addLast(extraPlate);
            }


            while (!plates.isEmpty() && !spartans.isEmpty()) {
                int plate = plates.poll();
                int warrior = spartans.pop();

                if (warrior > plate) {
                    spartans.push(warrior - plate);
                } else if (plate > warrior) {
                    plates.push(plate - warrior);
                }
            }
            if (plates.isEmpty()) {
                break;
            }

        }

        if (!spartans.isEmpty()) {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            System.out.print("Warriors left: " + spartans.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else if (!plates.isEmpty()) {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.println("Plates left: " + plates.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

    }
}
