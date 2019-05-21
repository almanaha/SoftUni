package SetsAndMaps.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int n = Integer.parseInt(sc.nextLine());
        Set<String> samples = new TreeSet<>();

        while (n-- > 0){
            String[] data = sc.nextLine().split(" ");
            samples.addAll(Arrays.asList(data));
        }
        for (String sample : samples) {
            System.out.print(sample + " ");
        }
    }
}
