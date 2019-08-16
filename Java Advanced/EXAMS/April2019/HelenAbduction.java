package EXAMS.April2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelenAbduction {
    private static int playerRow = 0;
    private static int playerCol = 0;
    private static char[][] field;


    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int playerEnergy = Integer.parseInt(sc.readLine());
        int rows = Integer.parseInt(sc.readLine());
        field = new char[rows][rows];

        for (int i = 0; i < rows; i++) {
            field[i] = sc.readLine().toCharArray();
        }
        findParis();

        while (true) {
            String[] data = sc.readLine().split("\\s+");
            int enemyRow = Integer.parseInt(data[1]);
            int enemyCol = Integer.parseInt(data[2]);
            field[enemyRow][enemyCol] = 'S';
            field[playerRow][playerCol] = '-';

            switch (data[0]) {
                case "up":
                    if (playerRow - 1 >= 0) {
                        playerRow--;
                    }
                    break;
                case "down":
                    if (playerRow + 1 < field.length) {
                        playerRow++;
                    }
                    break;
                case "left":
                    if (playerCol - 1 >= 0) {
                        playerCol--;
                    }
                    break;
                case "right":
                    if (playerCol + 1 < field.length) {
                        playerCol++;
                    }
                    break;
            }
            playerEnergy--;
            if (playerEnergy == 0){
                parisIsDead();
                return;
            }

            if (field[playerRow][playerCol] == 'S') {
                playerEnergy -= 2;
                if (playerEnergy == 0){
                    parisIsDead();
                    return;
                }else {
                    field[playerRow][playerCol] = '-';
                }
            }else if (field[playerRow][playerCol] == 'H') {
                field[playerRow][playerCol] = '-';
                System.out.print("Paris has successfully abducted Helen! ");
                System.out.println("Energy left: " + playerEnergy);
                printMatrix();
                return;
            }

        }

    }

    private static void parisIsDead() {
        field[playerRow][playerCol] = 'X';
        System.out.printf("Paris died at %d;%d.",
                playerRow,
                playerCol).println();
        printMatrix();
    }

    private static void printMatrix() {
        for (char[] chars : field) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void findParis() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
    }
}
