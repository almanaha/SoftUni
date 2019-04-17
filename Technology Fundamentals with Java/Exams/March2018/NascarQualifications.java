package Exams.March2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class NascarQualifications {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        List<String> players = Arrays.stream(sc.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String input;
        while (!"end".equals(input = sc.readLine())) {
            String[] cmd = input.split("\\s+");
            String racer = cmd[1];
            switch (cmd[0]){
                case "Race":
                    if (!players.contains(racer)){
                        players.add(racer);
                    }
                    break;
                case "Accident":
                    players.remove(racer); break;
                case "Box":
                    if (players.contains(racer) && players.indexOf(racer) != players.size() - 1){
                        int index  = players.indexOf(racer);
                        players.set(index, players.get(index + 1));
                        players.set(index + 1, racer);
                    }
                    break;
                case "Overtake":
                    int overtakes = Integer.parseInt(cmd[2]);
                    int index  = players.indexOf(racer);

                    if (players.contains(racer) && index != -1 &&
                    index - overtakes >= 0){
                        players.remove(racer);
                        players.add(index - overtakes, racer);
                    }
                    break;
            }
        }
        System.out.println(String.join(" ~ ", players));
    }
}
