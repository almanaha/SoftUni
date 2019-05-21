package SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class WarCardGame {
    public static Scanner sc = new Scanner(System.in);
    public static Set<Integer> deck1;
    public static Set<Integer> deck2;
    public static int p1Card;
    public static int p2Card;

    public static void main(String[] args) {
        deck1 = getCards();
        deck2 = getCards();

        // Game end after 50 rounds or if any player lose all of his numbers
        for (int i = 0; i < 50; i++) {
            if (deck1.isEmpty() || deck2.isEmpty()) {
                break;
            }
            // Iterator<Integer> iterator = deck.iterator();
            p1Card = deck1.iterator().next();
            p2Card = deck2.iterator().next();

            deck1.remove(p1Card);
            deck2.remove(p2Card);

            if (p1Card == p2Card) {
                addCards(3);
                continue;
            }
            addCards(p2Card > p1Card ? 2 : 1);

        }
        if (deck1.size() == deck2.size()) {
            System.out.println("Draw!");
        } else {
            System.out.println(deck1.size() > deck2.size() ? "First player win!" : "Second player win!");
        }

    }

    private static void addCards(int n) {
        switch (n) {
            case 1:
                deck1.add(p1Card);
                deck1.add(p2Card);
                break;
            case 2:
                deck2.add(p1Card);
                deck2.add(p2Card);
                break;
            case 3:
                deck1.add(p1Card);
                deck2.add(p2Card);
                break;
        }
    }

    private static Set<Integer> getCards() {
        return Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
