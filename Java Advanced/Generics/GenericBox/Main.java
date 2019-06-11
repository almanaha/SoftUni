package Generics.GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        List<Box<String>> list = new ArrayList<>();

        int n = Integer.parseInt(sc.readLine());
        while (n-- > 0) {
            String data = sc.readLine();
            Box<String> box = new Box<>(data);

            list.add(box);
        }

        String input = sc.readLine();
        Box<String> comparator = new Box<>(input);
        System.out.println(countValues(list, comparator));

    }

    public static <T extends Comparable<T>> int countValues(List<Box<T>> list, Box<T> box) {
        int counter = 0;
        for (Box<T> t : list) {
            if (t.compareTo(box) > 0) {
                counter++;
            }
        }
        return counter;
    }
}