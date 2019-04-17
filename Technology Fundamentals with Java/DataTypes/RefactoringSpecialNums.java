package DataTypes;
import java.util.Scanner;

public class RefactoringSpecialNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            index = i;
            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }
            if(sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True%n", index);
            }else {
                System.out.printf("%d -> False%n", index);
            }
            sum = 0;
            i = index;
        }
    }
}
