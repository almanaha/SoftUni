package EXAMS.August2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BombField {
    public static char[][] matrix;
    public static int playerRow;
    public static int playerCol;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int dimension = Integer.parseInt(sc.readLine());
        int bombsCount = 0;
        String[] directions = sc.readLine().split(",");
        matrix = new char[dimension][];
        for (int i = 0; i < dimension; i++) {
            String line = sc.readLine().replaceAll("\\s+", "");
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (c == 'B'){
                    bombsCount++;
                }else if (c == 's'){
                    playerRow = i;
                    playerCol = j;
                }

            }
            matrix[i] = line.toCharArray();
        }

        for (String move : directions) {
            switch (move) {
                case "up":
                    if (playerRow > 0){
                        playerRow--;
                    }
                    break;
                case "down":
                    if (playerRow < dimension - 1){
                        playerRow++;
                    }
                    break;
                case "left":
                    if (playerCol > 0){
                        playerCol--;
                    }
                    break;
                case "right":
                    if (playerCol < dimension - 1){
                        playerCol++;
                    }
                    break;
            }

            if (matrix[playerRow][playerCol] == 'e'){
                System.out.printf("END! %d bombs left on the field\n",bombsCount);
                return;
            }
            if (matrix[playerRow][playerCol] == 'B'){
                System.out.println("You found a bomb!");
                matrix[playerRow][playerCol] = '+';
                bombsCount--;
                if (bombsCount == 0){
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            }
        }

        if (bombsCount > 0){
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)\n",bombsCount,playerRow,playerCol);
        }

    }
}
