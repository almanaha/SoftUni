package EXAMS.February2019;

import java.util.*;

public class ExcelFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        String[][] matrix = new String[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = sc.nextLine().split(", ");
        }
        String[] cmd = sc.nextLine().split("\\s+");
        String command = cmd[0];
        String col = cmd[1];

        if (command.equals("hide")) {
            hideColumn(matrix, col);
        }else if (command.equals("sort")){
            sortColumns(matrix, col);
        }else {
            String value = cmd[2];
            filterColumn(matrix, col,value);
        }
    }

    private static void filterColumn(String[][] matrix, String filterColumn,String value) {
        int indexCol = getIndexCol(matrix[0], filterColumn);

        System.out.println(String.join(" | ",matrix[0]));
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][indexCol].equals(value)){
                System.out.println(String.join(" | ",matrix[i]));
            }
        }

    }

    private static void sortColumns(String[][] matrix, String sortCol) {
        int sortColumnIndex = getIndexCol(matrix[0], sortCol);

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 1; i < matrix.length - 1 - j; i++) {
                if (matrix[i][sortColumnIndex]
                        .compareTo(matrix[i + 1][sortColumnIndex]) > 0) {
                    String[] temp = matrix[i];
                    matrix[i] = matrix[i + 1];
                    matrix[i + 1] = temp;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != matrix[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }

    }

    private static void hideColumn(String[][] matrix, String hiddenColumn) {
        int indexCol = getIndexCol(matrix[0], hiddenColumn);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == indexCol) {
                    continue;
                }
                System.out.print(matrix[i][j]);
                if (j != matrix[i].length - 1) {
                    if (!(j == matrix[i].length - 2 && indexCol == j + 1)){
                        System.out.print(" | ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static int getIndexCol(String[] matrix, String hiddenColumn) {
        int indexCol = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].equals(hiddenColumn)) {
                indexCol = i;
                break;
            }
        }
        return indexCol;
    }
}
