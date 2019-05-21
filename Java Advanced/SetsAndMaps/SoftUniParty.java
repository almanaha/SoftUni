package SetsAndMaps;

import java.util.*;

public class SoftUniParty {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Set<String> guestList = new TreeSet<>();

        String guest;
        while (!"PARTY".equals(guest = sc.nextLine())){
            guestList.add(guest);
        }
        while (!"END".equals(guest = sc.nextLine())){
            guestList.remove(guest);
        }
        System.out.println(guestList.size());
        guestList.forEach(System.out::println);
    }
}
