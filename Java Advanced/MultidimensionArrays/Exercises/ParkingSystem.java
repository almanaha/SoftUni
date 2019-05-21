package MultidimensionArrays.Exercises;

import java.io.*;

public class ParkingSystem {

    private static int[][] parking;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = reader.readLine().split("\\s+");

        int matrixRows = Integer.valueOf(dimensions[0]);
        int matrixCols = Integer.valueOf(dimensions[1]);
        parking = new int[matrixRows][matrixCols];

        String line = reader.readLine();

        while (! line.equals("stop")) {
            int steps;

            String[] tokens = line.split("\\s+");
            int entry = Integer.valueOf(tokens[0]);
            int row = Integer.valueOf(tokens[1]);
            int col = Integer.valueOf(tokens[2]);

            if (checkIfRowIsNotFree(row)) {
                System.out.println("Row " + row + " full");
            } else {
                if (parking[row][col] == 0) {
                    steps = calculateSteps(entry, row, col);
                    parking[row][col] = 1;
                    System.out.println(steps);

                } else if (parking[row][col] == 1) {
                    col = findingPerfectFreeParkingSpot(row, col);
                    steps = calculateSteps(entry, row, col);
                    parking[row][col] = 1;
                    System.out.println(steps);

                }
            }

            line = reader.readLine();
        }

    }

    private static int findingPerfectFreeParkingSpot(int row, int position) {

        int result = 0;

        int left = 0;
        int right = 0;

        int rotations = parking[row].length;
        while (rotations -- >= 0) {
            left++;
            right++;
            if (position - left > 0) {
                if (parking[row][position - left] == 0) {
                    return position - left;
                }
            }
            if (position + right < parking[row].length) {
                if (parking[row][position + right] == 0) {
                    return position + right;
                }
            }
        }

        return result;
    }

    private static int calculateSteps(int entry, int row, int col) {

        int result = -1;

        for (int start = entry; start <= col; start++) {
            if (col == entry) {
                break;
            }
            result++;
        }

        for (int start = 0; start <= row; start++) {
            result++;
        }

        return result;
    }

    private static boolean checkIfRowIsNotFree(int row) {

        for (int col = 1; col < parking[row].length; col++) {
            if(parking[row][col] == 0) {
                return false;
            }
        }
        return true;
    }
}