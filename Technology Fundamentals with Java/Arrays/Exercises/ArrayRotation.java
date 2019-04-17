package Arrays.Exercises;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split(" ");
        int rotation = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < rotation; i++) {
            String element = array[0];
            for (int j = 0; j < array.length-1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = element;
        }
        for (String s : array) {
            System.out.print(s + " ");
        }
    }
}
