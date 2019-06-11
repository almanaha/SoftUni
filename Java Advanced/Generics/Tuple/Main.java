package Generics.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


        String[] data = sc.readLine().split("\\s+");
        Tuple<String, String> tuple1 =
                new Tuple<>(data[0] + " " + data[1], data[2]);
        System.out.println(tuple1.toString());

        data = sc.readLine().split("\\s+");

        Tuple<String, Integer> tuple2 =
                new Tuple<>(data[0], Integer.parseInt(data[1]));
        System.out.println(tuple2.toString());

        data = sc.readLine().split("\\s+");

        Tuple<Integer, Double> tuple3 =
                new Tuple<>(Integer.parseInt(data[0]), Double.parseDouble(data[1]));
        System.out.println(tuple3.toString());
    }
}