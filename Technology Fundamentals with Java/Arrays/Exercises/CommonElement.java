package Arrays.Exercises;

import java.util.Scanner;

public class CommonElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] x = sc.nextLine().split(" ");
        String[] y = sc.nextLine().split(" ");

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                if (x[i].equals(y[j])) {
                    System.out.print(x[i] + " ");
                }
            }
        }
    }
}
