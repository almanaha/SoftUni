package Exams.March2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BonusSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int students = Integer.parseInt(sc.readLine());
        int lectures = Integer.parseInt(sc.readLine());
        int bonus = Integer.parseInt(sc.readLine());

        double bestPoints = 0d;
        int bestAttendance = 0;

        for (int i = 0; i < students; i++) {
            double current = 0;
            int attendance = Integer.parseInt(sc.readLine());

            current =  Math.ceil((attendance / (double)lectures) * (5 + bonus));
           if (current > bestPoints || attendance > bestAttendance){
               bestAttendance = attendance;
               bestPoints = current;
           }
        }

        System.out.printf("The maximum bonus score for this course is %.0f.The student has attended %d lectures.",bestPoints,bestAttendance);


    }
}
