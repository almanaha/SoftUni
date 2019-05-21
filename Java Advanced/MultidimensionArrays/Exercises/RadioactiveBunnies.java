package MultidimensionArrays.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadioactiveBunnies {
    private static int playerRow = 0;
    private static int playerCol = 0;
    private static int rows;
    private static int cols;
    private static boolean hasWon = false;
    private static boolean hasDied = false;
    private static List<char[]> bunnyLair = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int[] rc = Arrays.stream(sc.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        rows = rc[0];
        cols = rc[1];

        for (int i = 0; i < rows; i++) {
            String line = sc.readLine();
            int player = line.indexOf('P');
            if (player != -1) {
                playerRow = i;
                playerCol = player;
            }
            bunnyLair.add(line.toCharArray());
        }

        String directions = sc.readLine();

        for (char move : directions.toCharArray()) {

            switch (move) {
                case 'U':
                    if (playerRow == 0) {
                        hasWon = true;
                        removePlayer();
                    } else {
                        if (bunnyLair.get(playerRow - 1)[playerCol] == 'B') {
                            hasDied = true;
                        } else {
                            bunnyLair.get(playerRow - 1)[playerCol] = 'P';
                        }
                        removePlayer();
                        playerRow--;
                    }
                    break;
                case 'D':
                    if (playerRow == rows - 1) {
                        hasWon = true;
                        removePlayer();
                    } else {
                        if (bunnyLair.get(playerRow + 1)[playerCol] == 'B') {
                            hasDied = true;
                        } else {
                            bunnyLair.get(playerRow + 1)[playerCol] = 'P';
                        }
                        removePlayer();
                        playerRow++;
                    }
                    break;
                case 'L':
                    if (playerCol == 0) {
                        hasWon = true;
                        removePlayer();
                    } else {
                        if (bunnyLair.get(playerRow)[playerCol - 1] == 'B') {
                            hasDied = true;
                        } else {
                            bunnyLair.get(playerRow)[playerCol - 1] = 'P';
                        }
                        removePlayer();
                        playerCol--;
                    }
                    break;
                case 'R':
                    if (playerCol == cols - 1) {
                        hasWon = true;
                        removePlayer();
                    } else {
                        if (bunnyLair.get(playerRow)[playerCol + 1] == 'B') {
                            hasDied = true;
                        } else {
                            bunnyLair.get(playerRow)[playerCol + 1] = 'P';
                        }
                        removePlayer();
                        playerCol++;
                    }
                    break;
            }

            bunnyLair = mutation();

            if (hasWon) {
                hasDied = false;
                break;
            }
            if (hasDied) {
                break;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(bunnyLair.get(i)[j]);
            }
            System.out.println();
        }

        System.out.printf("%s: %d %d\n",
                hasWon ? "won" : "dead",
                playerRow,
                playerCol);
    }

    private static void removePlayer() {
        bunnyLair.get(playerRow)[playerCol] = '.';
    }

    private static List<char[]> mutation() {
        List<char[]> newLair = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            newLair.add(new char[cols]);
            for (int j = 0; j < cols; j++) {
                newLair.get(i)[j] = bunnyLair.get(i)[j];
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (bunnyLair.get(r)[c] == 'B') {
                    if (r > 0) {
                        if (bunnyLair.get(r - 1)[c] == 'P') {
                            hasDied = true;
                        }
                        newLair.get(r - 1)[c] = 'B';
                    }
                    if (r < rows - 1) {
                        if (bunnyLair.get(r + 1)[c] == 'P') {
                            hasDied = true;
                        }
                        newLair.get(r + 1)[c] = 'B';
                    }
                    if (c > 0) {
                        if (bunnyLair.get(r)[c - 1] == 'P') {
                            hasDied = true;
                        }
                        newLair.get(r)[c - 1] = 'B';
                    }
                    if (c < cols - 1) {
                        if (bunnyLair.get(r)[c + 1] == 'P') {
                            hasDied = true;
                        }
                        newLair.get(r)[c + 1] = 'B';
                    }
                }
            }
        }
        return newLair;
    }
}
