package Generics.CountMethodInteger;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Box<Integer> box = new Box<>();


        IntStream
                .range(0, Integer.parseInt(sc.readLine()))
                .forEach(e -> {
                    try {
                        box.add(Integer.parseInt(sc.readLine()));
                    } catch (IOException ex) {
                        ex.getMessage();
                    }
                });

        int[] data = Arrays.stream(sc.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf).toArray();
        box.swap(data[0], data[1]);

        System.out.println(box.toString());
    }
}