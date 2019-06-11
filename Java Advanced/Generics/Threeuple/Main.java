package Generics.Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] data;
        data = sc.readLine().split("\\s+");
        new Threeuple<>(data[0] + " " + data[1], data[2], data[3]).print();

        data = sc.readLine().split("\\s+");
        new Threeuple<>(data[0], Integer.parseInt(data[1]), data[2].equals("drunk")).print();

        data = sc.readLine().split("\\s+");
        new Threeuple<>(data[0], Double.parseDouble(data[1]), data[2]).print();
    }
}
