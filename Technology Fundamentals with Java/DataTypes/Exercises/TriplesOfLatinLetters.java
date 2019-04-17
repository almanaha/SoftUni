package DataTypes.Exercises;

import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < x; k++) {
                    System.out.print((char)('a' + i));
                    System.out.print((char)('a' + j));
                    System.out.print((char)('a' + k));
                    System.out.println();
                }
            }
        }
    }
}
