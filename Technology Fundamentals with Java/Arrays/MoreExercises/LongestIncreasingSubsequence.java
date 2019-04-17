package Arrays.MoreExercises;

import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sequence = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] length = new int[sequence.length];
        int[] prev = new int[sequence.length];
        int maxLength = 0;
        int maxIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            int bestLength = 1;
            int index = -1;

            int element = sequence[i];

            for (int j = 0; j < i; j++) {
                if (sequence[j] < element && bestLength < length[j] + 1) {
                    bestLength = length[j] + 1;
                    index = j;
                }
            }

            length[i] = bestLength;
            prev[i] = index;

            if (maxLength < bestLength) {
                maxLength = bestLength;
                maxIndex = i;
            }
        }

        int[] result = new int[maxLength];
        int index = maxLength - 1;

        while (maxIndex != -1) {
            result[index--] = sequence[maxIndex];
            maxIndex = prev[maxIndex];
        }

        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
}
