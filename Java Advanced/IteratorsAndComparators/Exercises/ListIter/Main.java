package IteratorsAndComparators.Exercises.ListIter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        List<String> data = Arrays.stream(sc.readLine().split(" "))
                .skip(1)
                .collect(Collectors.toList());

        ListyIterator listyIter = new ListyIterator(data);

        String input;
        while (!"END".equals(input = sc.readLine())) {
            switch (input) {
                case "Move":
                    System.out.println(listyIter.move());
                    break;
                case "Print":
                    try {
                        System.out.println(listyIter.print());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIter.hasNext());
                    break;
                case "PrintAll":
                    for (String s : listyIter) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    break;

            }
        }
    }
}
