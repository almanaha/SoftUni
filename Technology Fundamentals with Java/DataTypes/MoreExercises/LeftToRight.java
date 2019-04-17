package DataTypes.MoreExercises;

import java.util.*;

public class LeftToRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0){
            long[] data = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToLong(Long::parseLong)
                    .toArray();

            long big = data[0];
            if (data[1] > data[0]){
                big = data[1];
            }

            long sum = 0;
            while (big != 0){
                sum += big % 10;
                big /= 10;
            }
            System.out.println(Math.abs(sum));
        }

    }
}
