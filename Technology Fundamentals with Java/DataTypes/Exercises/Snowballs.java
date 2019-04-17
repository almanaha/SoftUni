package DataTypes.Exercises;
import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double max = Integer.MIN_VALUE;
        int bestSnow = 0,
                bestTime = 0,
                bestQuality = 0;

        for (int i = 1; i <= n; i++){
            int snowballSnow = Integer.parseInt(sc.nextLine());
            int snowballTime = Integer.parseInt(sc.nextLine());
            int snowballQuality = Integer.parseInt(sc.nextLine());
            double snowballValue = Math.pow(snowballSnow / snowballTime,snowballQuality);
            if (snowballValue > max){
                max = snowballValue;
                bestSnow = snowballSnow;
                bestQuality = snowballQuality;
                bestTime = snowballTime;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)%n",bestSnow,bestTime,max,bestQuality);

    }
}