package Methods;

import java.util.Scanner;

public class SmallestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        int y = Integer.parseInt(sc.nextLine());
        int z = Integer.parseInt(sc.nextLine());
        printSmallest(x,y,z);
    }

    public static void printSmallest(int x,int y, int z) {
        int min = Math.min(x,y);
        int smallest = Math.min(min,z);
        System.out.println(smallest);
    }
}
