package Methods;

import java.util.Scanner;

public class PrintTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i < n; i++) {
            Triangle(1,i);
        }

        for (int i = n; i >= 1; i--) {
            Triangle(1,i);
        }
    }
    public static void Triangle(int start,int end){
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
