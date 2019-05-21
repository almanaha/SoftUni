package SetsAndMaps.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class HandOfCards {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        LinkedHashMap<String, HashSet<String>> playersDecks = new LinkedHashMap<>();

        String input = sc.nextLine();

        while (!input.equals("JOKER")){
            String[] data = input.split(": ");
            String name = data[0];
            HashSet<String> cards = Arrays.stream(data[1].split(", +"))
                    .collect(Collectors.toCollection(HashSet::new));

            if (!playersDecks.containsKey(name)){
                playersDecks.put(name,cards);
            }else{
                playersDecks.get(name).addAll(cards);
            }
            input = sc.nextLine();
        }

        for (String player : playersDecks.keySet()) {
            int power = getPower(playersDecks.get(player));
            System.out.println(player + ": " + power);
        }
    }

    private static int getPower(HashSet<String> deck) {
        int power = 0;
        int currentPower = 1;
        for (String card : deck) {
            switch (card.charAt(0)){
                case '2': currentPower = 2; break;
                case '3': currentPower = 3; break;
                case '4': currentPower = 4; break;
                case '5': currentPower = 5; break;
                case '6': currentPower = 6; break;
                case '7': currentPower = 7; break;
                case '8': currentPower = 8; break;
                case '9': currentPower = 9; break;
                case '1': currentPower = 10; break;
                case 'J': currentPower = 11; break;
                case 'Q': currentPower = 12; break;
                case 'K': currentPower = 13; break;
                case 'A': currentPower = 14; break;
            }
            switch (card.charAt(card.length() - 1)){
                case 'S': currentPower *= 4; break;
                case 'H': currentPower *= 3; break;
                case 'D': currentPower *= 2; break;
            }
            power += currentPower;
        }
        return power;
    }
}
