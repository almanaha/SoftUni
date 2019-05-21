package SetsAndMaps.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> types = new HashMap<String, Integer>() {{
            put("S",4);
            put("H",3);
            put("D",2);
            put("C",1);
        }};
        Map<String, Integer> powers = new HashMap<String, Integer>() {{
            put("J",11);
            put("Q",12);
            put("K",13);
            put("A",14);
        }};
        Map<String, Set<String>> players = new LinkedHashMap<>();

        String input;
        while (!"JOKER".equals(input = sc.nextLine())) {
            String[] data = input.split(": ");
            String name = data[0];

            Set<String> cards = Arrays.stream(data[1].split(",\\s+"))
                    .collect(Collectors.toCollection(HashSet::new));

            players.putIfAbsent(name, cards);
            players.get(name).addAll(cards);
        }

        for (Map.Entry<String, Set<String>> player : players.entrySet()) {
            int totalStrength = 0;
            for (String card : player.getValue()) {
                String power = card.substring(0, card.length() - 1);
                String type = String.valueOf(card.charAt(card.length() - 1));
                totalStrength += cardsStrength(power,type,powers,types);
            }
            System.out.printf("%s: %d%n",player.getKey(),totalStrength);
        }
    }

    private static int cardsStrength(String power, String type, Map<String, Integer> powers, Map<String, Integer> types) {

        int resultPower = 0;
        try {
            resultPower = Integer.parseInt(power);
        }catch (NumberFormatException nfe){
            resultPower = powers.get(power);
        }
        return types.get(type) * resultPower;
    }
}
