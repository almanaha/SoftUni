package FunctionalProgramming;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String[] money = sc.nextLine().split(", ");

        UnaryOperator<Double> addVAT = d -> 1.2 * d;

        System.out.println("Prices with VAT:");
        Arrays.stream(money)
                .map(Double::parseDouble)
                .map(addVAT)
                .forEach(e-> System.out.printf("%.2f%n",e));

    }
}
