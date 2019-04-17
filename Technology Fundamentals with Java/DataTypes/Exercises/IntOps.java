package DataTypes.Exercises;

import java.util.Scanner;

public class IntOps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        int x2 = Integer.parseInt(sc.nextLine());
        int divide = Integer.parseInt(sc.nextLine());
        int multiply = Integer.parseInt(sc.nextLine());

        System.out.println((x + x2) / divide * multiply);
    }
}
