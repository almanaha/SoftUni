package DataTypes;

import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String city = sc.nextLine();
        String population = sc.nextLine();
        String area = sc.nextLine();
        System.out.printf("Town %s has population of %s and area %s square km.",city,population,area);
    }
}
