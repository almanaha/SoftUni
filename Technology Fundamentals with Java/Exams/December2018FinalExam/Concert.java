package Exams.December2018FinalExam;

import java.util.*;
import java.util.stream.Collectors;

public class Concert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> club = new HashMap<>();
        Map<String, List<String>> members = new HashMap<>();

        int totalTime = 0;

        String cmd;
        while (!"start of concert".equals(cmd = sc.nextLine())) {
            String[] data = cmd.split(";\\s+");
            String bandName = data[1];
            switch (data[0]) {
                case "Add":
                    List<String> players = Arrays.stream(data[2].split(",\\s+")).collect(Collectors.toList());
                    club.putIfAbsent(bandName, 0);
                    members.putIfAbsent(bandName, new LinkedList<>());
                    for (String player : players) {
                        if (!members.get(bandName).contains(player)){
                            members.get(bandName).add(player);
                        }
                    }
                    break;
                case "Play":
                    int time = Integer.parseInt(data[2]);
                    totalTime += time;
                    club.putIfAbsent(bandName, 0);
                    club.put(bandName, club.get(bandName) + time);
                    break;
            }
        }
        String winners = sc.nextLine();

        System.out.println("Total time: " + totalTime);
        club.entrySet().stream()
                .sorted((x, y) -> y.getValue() == x.getValue() ?
                        x.getKey().compareTo(y.getKey()) :
                        Integer.compare(y.getValue(), x.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

        System.out.println(winners);
        members.get(winners)
                .forEach(e -> System.out.println("=> " + e));
    }
}
