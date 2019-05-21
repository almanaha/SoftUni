package MultidimensionArrays;
import java.util.Scanner;

public class IntersectionTwoMatricies {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());
        char[][] matrix1 = new char[rows][cols];
        char[][] matrix2 = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] data = sc.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = data[j].charAt(0);
            }
        }
        for (int i = 0; i < rows; i++) {
            String[] data = sc.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = data[j].charAt(0);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix1[i][j] == matrix2[i][j]){
                    System.out.print(matrix1[i][j]);
                }else{
                    System.out.print("*");
                }
                if (j != cols - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
