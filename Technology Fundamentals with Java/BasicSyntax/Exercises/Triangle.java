package BasicSyntax.Exercises;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i<=n;i++){
            for (int g = 1; g <= i;g++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
