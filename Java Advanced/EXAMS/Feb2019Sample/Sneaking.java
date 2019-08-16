package EXAMS.Feb2019Sample;

import java.util.*;

public class Sneaking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[n][];
        int[] sam = new int[2];
        int[] nikola = new int[2];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("N")){
                nikola[0] = i;
                nikola[1] = line.indexOf("N");
            }else if (line.contains("S")){
                sam[0] = i;
                sam[1] = line.indexOf("S");
            }
        }

        String command = sc.nextLine();
        for (int i = 0; i < command.length(); i++) {
            moveEnemies(matrix);
            boolean samIsDead = deadOrAlive(matrix, sam);

            if (samIsDead){
                matrix[sam[0]][sam[1]] = 'X';
                System.out.println(String.format("Sam died at %d, %d",
                        sam[0],sam[1]));
                break;
            }else{
                moveSam(matrix,sam,command.charAt(i));
            }

            if (nikola[0] == sam[0]){
                System.out.println("Nikoladze killed!");
                matrix[nikola[0]][nikola[1]] = 'X';
                break;
            }

        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }

    }

    private static void moveSam(char[][] matrix, int[] sam, char direction) {
        if (direction == 'U'){
            matrix[sam[0]--][sam[1]] = '.';
            matrix[sam[0]][sam[1]] = 'S';
        }else if (direction == 'D'){
            matrix[sam[0]++][sam[1]] = '.';
            matrix[sam[0]][sam[1]] = 'S';
        }else if (direction == 'R'){
            matrix[sam[0]][sam[1]++] = '.';
            matrix[sam[0]][sam[1]] = 'S';
        }else if (direction == 'L'){
            matrix[sam[0]][sam[1]--] = '.';
            matrix[sam[0]][sam[1]] = 'S';
        }
    }

    private static boolean deadOrAlive(char[][] matrix, int[] sam) {
        for (int i = 0; i < sam[1]; i++) {
            if (matrix[sam[0]][i] == 'b'){
                return true;
            }
        }

        for (int i = sam[1] + 1; i < matrix[sam[0]].length; i++) {
            if (matrix[sam[0]][i] == 'd'){
                return true;
            }
        }
        return false;
    }

    private static void moveEnemies(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'b'){
                    if (c == matrix[r].length - 1){
                        matrix[r][c] = 'd';
                    }else{
                        matrix[r][c] = '.';
                        matrix[r][c + 1] = 'b';
                        break;
                    }
                }else if (matrix[r][c] == 'd'){
                    if (c == 0){
                        matrix[r][c] = 'b';
                    }else{
                        matrix[r][c] = '.';
                        matrix[r][c - 1] = 'd';
                        break;
                    }
                }
            }
        }
    }
}
