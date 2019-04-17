package ExtraWork;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = 13;

        String binary = Integer.toBinaryString(x);
        System.out.println("Binary: " + binary);

        String bin = Integer.toString(x,2);
        System.out.println(bin);

        // HehaDecimal

        int a = 0xFF;
        System.out.println(a);


        double number = Math.pow(2,64);
        System.out.println(number);
    }
}
