package Arrays.Exercises;

import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();

        int bestLength = 0;
        String bestDna = "";
        int bestIndex = 0;
        int bestSum = 0;
        int counter = 0;
        int bestCounter = 0;

        while (!line.equals("Clone them!")) {
            counter++;
            String sequence = line.replaceAll("!", "");
            String[] dna = sequence.split("0");

            int max = 0;
            String bestLocalDna = "";
            int sum = 0;
            for (int i = 0; i < dna.length; i++) {
                if (dna[i].length() > max) {
                    max = dna[i].length();
                    bestLocalDna = dna[i];
                }
                sum += dna[i].length();
            }

            int startIndex = sequence.indexOf(bestLocalDna);

            if (max > bestLength) {
                    bestLength = max;
                    bestDna = sequence;
                    bestIndex = startIndex;
                    bestSum = sum;
                    bestCounter = counter;
            } else if (max == bestLength && (startIndex < bestIndex || sum > bestSum)) {
                    bestLength = max;
                    bestDna = sequence;
                    bestIndex = startIndex;
                    bestSum = sum;
                    bestCounter = counter;
            } else if (counter == 1) {
                    bestLength = max;
                    bestDna = sequence;
                    bestIndex = startIndex;
                    bestSum = sum;
                    bestCounter = counter;
            }

            line = sc.nextLine();
        }

        System.out.println(String.format("Best DNA sample %d with sum: %d.",
                bestCounter, bestSum));
        for (int i = 0; i < bestDna.length(); i++) {
            System.out.print(bestDna.charAt(i) + " ");
        }
        System.out.println();

    }
}
