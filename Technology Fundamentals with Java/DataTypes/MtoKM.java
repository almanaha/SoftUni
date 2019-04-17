package DataTypes;

import java.util.Scanner;

public class MtoKM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double meters = Double.parseDouble(sc.nextLine());
        System.out.printf("%.2f",meters / 1000);
    }
}
