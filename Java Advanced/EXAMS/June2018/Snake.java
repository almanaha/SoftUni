package EXAMS.June2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake {

    private static char[][] matrix;
    private static int playerRow = 0;
    private static int playerCol = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(sc.readLine());
        String[] directions = sc.readLine().split(",\\s+");
        int food = 0;
        matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.readLine().replaceAll("\\s+", "");
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (c == 'f') {
                    food++;
                }else if (c == 's') {
                    playerRow = i;
                    playerCol = j;
                }
            }
            matrix[i] = line.toCharArray();
        }

        int snakeLenght = 1;

        for (String move : directions) {
            switch (move) {
                case "up":
                    if (playerRow > 0) {
                        playerRow--;
                    } else if (playerRow == 0) {
                        playerRow = n - 1;
                    }
                    break;
                case "down":
                    if (playerRow < n - 1) {
                        playerRow++;
                    } else if (playerRow == n - 1) {
                        playerRow = 0;
                    }
                    break;
                case "left":
                    if (playerCol > 0) {
                        playerCol--;
                    } else if (playerCol == 0) {
                        playerCol = n - 1;
                    }
                    break;
                case "right":
                    if (playerCol < n - 1) {
                        playerCol++;
                    } else if (playerCol == n - 1) {
                        playerCol = 0;
                    }
                    break;
            }
//            System.out.println(playerRow+" "+playerCol);

            if (matrix[playerRow][playerCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }

            if (matrix[playerRow][playerCol] == 'f') {
                food--;
                snakeLenght++;
                if (food == 0) {
                    System.out.println("You win! Final snake length is " + snakeLenght);
                    return;
                }
            }
        }

        if (food > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.\n", food);
        }
    }
}
