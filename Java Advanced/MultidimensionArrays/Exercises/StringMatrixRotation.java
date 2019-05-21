package MultidimensionArrays.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String[] input = sc.nextLine().split("[()]+");
        int rotate = Integer.parseInt(input[1]) % 360;

        List<String> str = new ArrayList<>();

        String line = sc.nextLine();
        int length = line.length();

        while (!line.equals("END")){
            str.add(line);
            line = sc.nextLine();
            if(line.length() > length){
                length = line.length();
            }
        }

        char[][] matrix = new char[str.size()][length];

        for (int r = 0; r < str.size(); r++) {
            for (int c = 0; c < length; c++) {
                if (c > str.get(r).length() - 1){
                    matrix[r][c] = ' ';
                }else{
                    matrix[r][c] = str.get(r).charAt(c);
                }
            }
        }
        if (rotate == 90){
            for (int c = 0; c < length; c++) {
                for (int r = matrix.length - 1; r >= 0 ; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }else if (rotate == 180){
            for (int r = matrix.length - 1; r >= 0; r--) {
                for (int c = length - 1; c >= 0 ; c--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }else if (rotate == 270){
            for (int c = length - 1; c >= 0; c--) {
                for (int r = 0; r < matrix.length ; r++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }else {
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < length; c++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }
    }
}
