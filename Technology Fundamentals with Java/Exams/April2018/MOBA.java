package Exams.April2018;

import java.util.*;

public class MOBA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Integer>> players = new HashMap<>();

        String input;
        while (!"Season end".equals(input = sc.nextLine())){
            if (input.contains(" -> ")){
                String[] data = input.split(" -> ");
                String player = data[0];
                String position = data[1];
                int skill = Integer.parseInt(data[2]);

                if (!players.containsKey(player)) {
                    players.putIfAbsent(player, new HashMap<>());
                    players.get(player).put(position, skill);
                }else{
                    if (!players.get(player).containsKey(position)){
                        players.get(player).put(position, skill);
                    }else if (players.get(player).get(position) < skill){
                        players.get(player).put(position, skill);
                    }
                }
            }else if (input.contains(" vs ")){
                String[] battle = input.split(" vs ");
                String player1 = battle[0];
                String player2 = battle[1];

                if (players.containsKey(player1) && players.containsKey(player2)){
                    for (String player : players.keySet()) {
                        for (Map<String, Integer> value : players.values()) {
                            int x = value.get(player1);
                            int y = value.get(player2);
                            if (x < y){
                                players.remove(player1);
                                break;
                            }else{
                                players.remove(player2);
                                break;
                            }
                        }
                    }
                }
            }
        }

        for (String s : players.keySet()) {
        }
    }
}
