package DataTypes.Exercises;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int people = Integer.parseInt(sc.nextLine());
        int capacity = Integer.parseInt(sc.nextLine());

        double courses = Math.ceil((double)people/capacity);

        if (people <= capacity)
            System.out.println(1);
        else
            System.out.printf("%.0f",courses);
    }
}
