package EXAMS.May2015;

import java.io.*;
import java.util.*;

public class TargetPractice {
    private static String snake;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int[] sizes = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        snake = sc.readLine();
        String[] target = sc.readLine().split(" ");

        String[][] matrix = new String[sizes[0]][sizes[1]];
        fillMatrix(matrix);

        shootInMatrix(target, matrix);

        elementsFall(matrix);

        printMatrix(matrix);
    }

    private static void elementsFall(String[][] matrix) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < matrix[0].length; i++) {
            for (String[] strings : matrix) {
                if (!strings[i].equals(" ")) {
                    stack.add(strings[i]);
                }
            }

            for (int j = matrix.length - 1; j >= 0; j--) {
                if (stack.size() != 0) {
                    matrix[j][i] = stack.pop();
                } else {
                    matrix[j][i] = " ";
                }
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }

    private static void shootInMatrix(String[] target, String[][] matrix) {
        int centerRow = Integer.parseInt(target[0]);
        int centerCol = Integer.parseInt(target[1]);
        int radius = Integer.parseInt(target[2]);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                double d = Math.sqrt((centerRow - row) * (centerRow - row) + (centerCol - col) * (centerCol - col));
                if (d <= radius) {
                    matrix[row][col] = " ";
                }
            }
        }
    }

    private static void fillMatrix(String[][] matrix) {
        boolean isMovingLegt = true;

        for (int row = matrix.length - 1; row >= 0; row--) {
            int col = isMovingLegt ? matrix[0].length - 1 : 0;
            int colUpdate = isMovingLegt ? -1 : 1;

            while (0 <= col && col <= matrix[0].length - 1) {
                matrix[row][col] = getsymbol();
                col += colUpdate;
            }

            isMovingLegt = !isMovingLegt;
        }
    }

    private static String getsymbol() {
        if (sb.length() == 0) {
            sb.append(snake);
        }
        String rem = sb.substring(0, 1);
        sb.delete(0, 1);
        return rem;
    }
}
