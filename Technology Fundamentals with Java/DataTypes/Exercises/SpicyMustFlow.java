package DataTypes.Exercises;
import java.util.Scanner;

public class SpicyMustFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int spice = Integer.parseInt(sc.nextLine());
        int days = 0;
        int total = 0;

        while (spice >= 100){
            days++;
            total += (spice - 26);
            spice -= 10;
        }
        if (total >= 26){
            total -= 26;
        }
        System.out.println(days);
        System.out.println(total);
    }
}
