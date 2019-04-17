package DataTypes.MoreExercises;

import java.util.Scanner;

public class DecryptingMessages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = Integer.parseInt(sc.nextLine());
        int x = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < x; i++) {
            char letter = sc.nextLine().charAt(0);
            System.out.print((char)(letter + key));
        }
    }
}
