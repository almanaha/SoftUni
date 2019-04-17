package List.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> deck1 = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> deck2 = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!deck1.isEmpty() && !deck2.isEmpty()){
            int player1 = deck1.get(0);
            int player2 = deck2.get(0);
            if (player1 > player2) {
                deck1.add(player1);
                deck1.add(player2);
            }else if (player2 > player1){
                deck2.add(player2);
                deck2.add(player1);
            }
            deck1.remove(0);
            deck2.remove(0);
        }
        int sum = 0;

        if (deck1.size() > deck2.size()){
            for (Integer x : deck1) {
                sum += x;
            }
            System.out.println("First player wins! Sum: " + sum);
        }else{
            for (Integer x : deck2) {
                sum += x;
            }
            System.out.println("Second player wins! Sum: " + sum);
        }
    }
}
