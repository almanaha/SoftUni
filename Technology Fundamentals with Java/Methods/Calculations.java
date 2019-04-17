package Methods;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        int x = Integer.parseInt(sc.nextLine());
        int y = Integer.parseInt(sc.nextLine());

        switch (command){
            case "add": add(x,y); break;
            case "multiply": multiply(x,y); break;
            case "divide": divide(x,y); break;
            case "substract": substract(x,y); break;
        }
    }
    public static void add(int x,int y){
        System.out.println(x + y);
    }
    public static void multiply(int x,int y){
        System.out.println(x * y);
    }
    public static void divide(int x,int y){
        System.out.println(x / y);
    }
    public static void substract(int x,int y) {
        System.out.println(x - y);
    }
}
