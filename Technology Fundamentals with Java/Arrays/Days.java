package Arrays;

import java.util.Scanner;

public class Days {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] weekDay = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        int day = Integer.parseInt(sc.nextLine());
        if (day >= 1 && day <= 7){
            System.out.println(weekDay[day-1]);
        }else{
            System.out.println("Invalid day!");
        }
    }
}
