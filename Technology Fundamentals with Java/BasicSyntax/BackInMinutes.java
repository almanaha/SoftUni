package BasicSyntax;

import java.util.Scanner;

public class BackInMinutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hours = Integer.parseInt(sc.nextLine());
        int minutes = Integer.parseInt(sc.nextLine());
        int totalMins = minutes + 30;
        if (totalMins > 60){
            hours++;
            totalMins -= 60;
        }
        if (hours >= 24){
            hours = 0;
        }
        if (totalMins >= 10){
            System.out.printf("%d:%d",hours,totalMins);
        }else{
            System.out.printf("%d:0%d",hours,totalMins);
        }


    }
}
