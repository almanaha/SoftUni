package Exams.January2018;

import java.util.*;
import java.util.stream.Collectors;

public class Snowmen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> snowmen = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (snowmen.size() > 1) {
                // index -->> attacker
            for (int attacker = 0; attacker < snowmen.size(); attacker++) {

                // target -->> Index
                int target = snowmen.get(attacker) % snowmen.size();

                int count = (int) snowmen.stream().filter(e -> e != -1).count();
                if (count == 1) {
                    break;
                }
                if (snowmen.get(attacker) == -1) { // current snowman is dead
                    continue;
                }
                int diff = Math.abs(attacker - target);

                if (attacker == target) {
                    System.out.printf("%d performed harakiri%n", attacker);
                    snowmen.set(attacker, -1);
                    continue;
                }
                if (diff % 2 == 0) {
                    // attacker wins
                    System.out.println(attacker + " x " + target + " -> " + attacker + " wins");
                    snowmen.set(target, -1);

                } else {
                    // target wins
                    System.out.println(attacker + " x " + target + " -> " + target+ " wins");
                    snowmen.set(attacker, -1);

                }
            }
            snowmen = snowmen.stream()
                    .filter(e -> e != -1)
                    .collect(Collectors.toList());
        }
    }
}
