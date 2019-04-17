package Methods;

import java.util.Scanner;

public class AddAndSubstract {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        int y = Integer.parseInt(sc.nextLine());
        int z = Integer.parseInt(sc.nextLine());
        int sum = sumOfTwoNumbers(x,y);
        int substract = substractOfTwoNumbers(sum,z);
        System.out.println(substract);
    }
    public static int sumOfTwoNumbers(int x,int y){
        return x + y;
    }
    public static int substractOfTwoNumbers(int sum,int y){
        return sum - y;
    }
}
