package Exams.Oct2018PartOne;

import java.util.*;

public class GoogleSearches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = Integer.parseInt(sc.nextLine());
        int users = Integer.parseInt(sc.nextLine()); // for singe day
        double money = Double.parseDouble(sc.nextLine()); // per search

        double total = 0;
        for (int i = 1; i <= users; i++) {
            double searchMoney = 0;
            int userWords = Integer.parseInt(sc.nextLine());
            if (userWords > 5){
                continue;
            }else if (userWords > 1){
                searchMoney += money;
                if (i % 3 == 0){
                    searchMoney *= 3;
                }
            }
            if (userWords == 1){
                searchMoney += money * 2;
                if (i % 3 == 0){
                    searchMoney *= 3;
                }
            }
            total += searchMoney;
        }
        total = total * days;

        System.out.printf("Total money earned for %s days: %.2f",days,total);
    }
}
