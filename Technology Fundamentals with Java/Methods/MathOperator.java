package Methods;

import java.util.Scanner;

public class MathOperator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        String operator = sc.nextLine();
        int second = Integer.parseInt(sc.nextLine());

        double total = Calculations(first,operator,second);
        System.out.println(total);

    }

    public static double Calculations(int x , String operator ,int y) {
        double result = 0;
        switch (operator){
            case "/": result = x / y;
            case "*": result = x * y;
            case "+": result = x + y;
            case "-": result = x - y;
        }
        return result;
    }
}
