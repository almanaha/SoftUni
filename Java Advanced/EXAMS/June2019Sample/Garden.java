package EXAMS.June2019Sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Garden {
    private static char[][] garden;
    private static int carrots = 0;
    private static int potatoes = 0;
    private static int lettuce = 0;
    private static int harmedVegies = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(sc.readLine());
        garden = new char[n][];

        for (int i = 0; i < n; i++) {
            garden[i] = sc.readLine().replaceAll("\\s+", "").toCharArray();
        }

        String input;
        while (!"End of Harvest".equalsIgnoreCase(input = sc.readLine())) {
            String[] data = input.split("\\s+");

            int row = Integer.parseInt(data[1]);
            int col = Integer.parseInt(data[2]);

            if (data[0].equalsIgnoreCase("Harvest")) {
                harvest(row, col);
            } else {
                mole(row, col, data[3]);
            }
        }
        printMatrix();
        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + harmedVegies);


    }

    private static void mole(int row, int col, String direction) {
        if (isInBounds(row, col)) {
            String harmed = "Harmed vegetables";
            switch (direction) {
                case "up":
                    for (int i = row; i >= 0; i -= 2) {
                        if (garden[i][col] == 'L' || garden[i][col] == 'P' || garden[i][col] == 'C') {
                            garden[i][col] = ' ';
                            harmedVegies++;
                        }

                    }
                    break;
                case "down":
                    for (int i = row; i < garden.length; i += 2) {
                        if (garden[i][col] == 'L' || garden[i][col] == 'P' || garden[i][col] == 'C') {
                            garden[i][col] = ' ';
                            harmedVegies++;
                        }
                    }
                    break;
                case "right":
                    for (int i = col; i < garden[row].length; i += 2) {
                        if (garden[row][i] == 'L' || garden[row][i] == 'P' || garden[row][i] == 'C') {
                            garden[row][i] = ' ';
                            harmedVegies++;
                        }
                    }
                    break;
                case "left":
                    for (int i = col; i >= 0; i -= 2) {
                        if (garden[row][i] == 'L' || garden[row][i] == 'P' || garden[row][i] == 'C') {
                            garden[row][i] = ' ';
                            harmedVegies++;
                        }
                    }
            }
        }
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 &&
                row < garden.length &&
                col >= 0 &&
                col < garden[row].length;
    }

    private static void harvest(int row, int col) {
        if (isInBounds(row, col) && garden[row][col] != ' ') {
            switch (garden[row][col]) {
                case 'C':
                    carrots++;
                    break;
                case 'P':
                    potatoes++;
                    break;
                case 'L':
                    lettuce++;
                    break;
            }
            garden[row][col] = ' ';
        }
    }

    private static void printMatrix() {
        for (char[] chars : garden) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
