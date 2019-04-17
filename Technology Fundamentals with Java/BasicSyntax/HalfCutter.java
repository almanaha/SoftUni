package BasicSyntax;

import java.util.Scanner;

public class HalfCutter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = Double.parseDouble(sc.nextLine());
        double length = n;
        int counter = 0;

        while (n >= 1){
            counter++;
            length /= 2;
        }
        System.out.printf("Length is %.2f cm after %d cuts.",length,counter);
    }
}
