package Exams.August2018PartOne;

import java.util.*;

public class Hogswatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int homes = Integer.parseInt(sc.nextLine());
        int gifts = Integer.parseInt(sc.nextLine());

        int homeCount = 0;
        int additionalPresents = 0;
        int presents = gifts;
        for (int i = 1; i <= homes; i++) {
            int kids = Integer.parseInt(sc.nextLine());
            if (presents >= kids){
                presents -= kids;
                continue;
            }
            homeCount++;
            int extra = kids - presents;
            int moreGifts = (gifts / i) * ( homes - i) + extra;
            additionalPresents += moreGifts;
            presents += moreGifts - kids;
        }

        if (homeCount == 0){
            System.out.println(presents);
        }else{
            System.out.println(homeCount);
            System.out.println(additionalPresents);
        }
    }
}
