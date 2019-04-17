package Exams.July2018PartOne;

import java.util.*;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // count of students that each of the employee can help per hour.
        int employee1 = Integer.parseInt(sc.nextLine());
        int employee2 = Integer.parseInt(sc.nextLine());
        int employee3 = Integer.parseInt(sc.nextLine());
        int studentsCount = Integer.parseInt(sc.nextLine());

        int studentsPerHour = employee1 + employee2 + employee3;
        int hours = 1;
        if (studentsCount == 0){
            System.out.println("Time needed: 0h.");
            return;
        }
        while (true){
            if (hours % 4 == 0){
                hours++;
                continue;
            }
            studentsCount -= studentsPerHour;
            if (studentsCount <= 0){
                break;
            }
            hours++;
        }
        System.out.println("Time needed: "+ hours +"h.");

    }
}
