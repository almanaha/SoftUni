package Exams.December2018FinalExam;

import java.util.*;

public class Concert2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Set<String>> members = new LinkedHashMap<>();
        Map<String, Integer> bandTime = new HashMap<>();
        int totalTime = 0;

        String input;
        while (!"start of concert".equals(input = scan.nextLine())) {
            String[] tokens = input.split(";\\s+");
            String bandName = tokens[1];

            if (tokens[0].equals("Add")) {
                String[] member = tokens[2].split(",\\s+");
                members.putIfAbsent(bandName, new LinkedHashSet<>());
                for (String m : member) {
                    members.get(bandName).add(m);
                }
            } else {
                bandTime.putIfAbsent(bandName, 0);
                bandTime.put(bandName, bandTime.get(bandName) + (Integer.parseInt(tokens[2])));
                totalTime += Integer.parseInt(tokens[2]);
            }
        }
        String winner = scan.nextLine();

        System.out.println(String.format("Total time: %d", totalTime));
        bandTime.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.println(String.format("%s -> %d",
                                entry.getKey(),
                                entry.getValue())));
        System.out.println(winner);
        members.get(winner).forEach(e -> System.out.println("=> " + e));
    }
}
