package EXAMS.February2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TronRacers {

    private static char[][] playfield;
    private static int firstX = 0;
    private static int firstY = 0;
    private static int secondX = 0;
    private static int secondY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(sc.readLine());

        playfield = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = sc.readLine();

            if (line.indexOf('f') != -1) {
                firstX = i;
                firstY = line.indexOf('f');
            } else if (line.indexOf('s') != -1) {
                secondX = i;
                secondY = line.indexOf('s');
            }

            playfield[i] = line.toCharArray();
        }

        boolean firstIsAlive;
        boolean secondIsAlive = true;

        while(secondIsAlive) {
            String[] line = sc.readLine().split("\\s+");

            firstIsAlive = movePlayer('f', firstX, firstY, line[0]);

            if (!firstIsAlive) { break; }

            secondIsAlive = movePlayer('s', secondX, secondY, line[1]);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(playfield[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean movePlayer(char player, int playerX, int playerY, String direction) {
        int newPlayerX = playerX;
        int newPlayerY = playerY;
        switch (direction) {
            case "up":
                newPlayerX = playerX - 1 < 0 ?
                        playfield.length - 1 : playerX - 1;
                break;
            case "down":
                newPlayerX = playerX + 1 >= playfield.length ?
                        0 : playerX + 1;
                break;
            case "left":
                newPlayerY = playerY - 1 < 0 ?
                        playfield.length - 1 : playerY - 1;
                break;
            case "right":
                newPlayerY = playerY + 1 >= playfield.length ?
                        0 : playerY + 1;
                break;
        }

        if ((playfield[newPlayerX][newPlayerY] == 'f' && player == 's') ||
                (playfield[newPlayerX][newPlayerY] == 's' && player == 'f')) {

            playfield[newPlayerX][newPlayerY] = 'x';
            return false;
        }

        playfield[newPlayerX][newPlayerY] = player;

        if (player == 'f') {
            firstX = newPlayerX;
            firstY = newPlayerY;
        } else {
            secondX = newPlayerX;
            secondY = newPlayerY;
        }

        return true;
    }
}

