package Generics.CountMethodDouble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Box<Double> box = new Box<>();

        IntStream
                .range(0, Integer.parseInt(sc.readLine()))
                .forEach(e -> {
                    try {
                        box.add(Double.parseDouble(sc.readLine()));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });

        System.out.println(box.countGreater(Double.parseDouble(sc.readLine())));
    }
}