package Exams.April2018;

import java.util.*;
import java.util.stream.Collectors;

public class TseamAcc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> games = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input;
        while (!"Play!".equals(input = sc.nextLine())){
            String[] data = input.split("\\s+");
            String game = data[1];
            switch (data[0]){
                case "Install":
                    if (!games.contains(game)){
                        games.add(game);
                    }
                    break;
                case "Uninstall":
                    games.remove(game);
                    break;
                case "Update":
                    if (games.contains(game)){
                        games.remove(game);
                        games.add(game);
                    }
                    break;
                case "Expansion":
                    String[] expansion = game.split("-");
                    int index = games.indexOf(expansion[0]);
                    if (index != -1){
                        games.add(index + 1, expansion[0] + ":" + expansion[1]);
                    }
                    break;
            }
        }
        games.stream().forEach(e -> System.out.print(e + " "));
    }
}
