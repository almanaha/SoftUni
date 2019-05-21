package SetsAndMaps.Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int[] lengthOfSets = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();

        fillSets(lengthOfSets, set1, 0);
        fillSets(lengthOfSets, set2, 1);

        // Find all non-repeating element that appears in both of them
        // retainAll --> removes from this Set all of its elements that are not contained in the specified collection
        set1.retainAll(set2);
        set1.forEach(s -> System.out.print(s + " "));
    }

    private static void fillSets(int[] lengthOfSets, Set<Integer> set2, int i) {
        while (lengthOfSets[i]-- > 0) {
            int number = Integer.parseInt(sc.nextLine());
            set2.add(number);
        }
    }
}
