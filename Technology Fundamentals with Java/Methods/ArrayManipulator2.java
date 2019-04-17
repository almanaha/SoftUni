package Methods;

import java.util.*;

public class ArrayManipulator2 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] matrix = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String cmd = sc.nextLine();
        while (!cmd.equals("end")){
            String[] data = cmd.split(" ");
            String command = data[0];

            if (command.equals("exchange")){
                int index = Integer.parseInt(data[1]);
                if (index > matrix.length - 1){
                    System.out.println("Invalid index");
                    continue;
                }
                exchangeIndex(matrix,index);
                
            }else if (command.equals("max")){
                String type = data[1];
                int index = -1; // ако се обърка да не върне 0 индекс
                if (type.equals("odd")){
                    index = getMax(matrix,1);
                }else{
                    index = getMax(matrix,0);
                }
                if (index == -1){
                    System.out.println("No matches");
                    continue;
                }
                System.out.println(index);
            }else if (command.equals("min")){
                String type = data[1];
                int index = -1;
                if (type.equals("odd")){
                    index = getMin(matrix,1);
                }else{
                    index = getMin(matrix,0);
                }
                if (index == -1){
                    System.out.println("No matches");
                    continue;
                }
                System.out.println(index);
            }else if (command.equals("first")){
                int count = Integer.parseInt(data[1]);
                String type = data[2];

                int[] result = new int[0];

                if (type.equals("odd")){
                    result = getFirstCount(matrix,count,1);
                }else{
                    result = getFirstCount(matrix,count,0);
                }
                for (int i = 0; i < result.length; i++) {
                    System.out.print(result[i] + " ");
                }
            }else if (command.equals("last")){
                int count = Integer.parseInt(data[1]);
                String type = data[2];

                int[] result = new int[0];

                if (type.equals("odd")){
                    result = getLastCount(matrix,count,1);
                }else{
                    result = getLastCount(matrix,count,0);
                }
                for (int i = 0; i < result.length; i++) {
                    System.out.print(result[i] + " ");
                }
            }
            cmd = sc.nextLine();
        }

    }

    private static int[] getLastCount(int[] matrix, int count, int divisionResult) {
        int[] arr = new int[count];
        int current = 0;

        for (int i = matrix.length - 1; i >= 0; i--) {
            if (matrix[i] % 2 == divisionResult && current < count){
                arr[current] = matrix[i];
                current++;
            }
        }
        if (current >= count){
            return arr;
        }
        int[] copy = new int[current];
        for (int i = copy.length - 1; i >= 0; i--) {
            copy[i] = arr[i];
        }
        return copy;
    }

    private static int[] getFirstCount(int[] matrix, int count, int divisionResult) {
        int[] arr = new int[count];
        int current = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] % 2 == divisionResult && current < count){
                arr[current] = matrix[i];
                current++;
            }
        }
        if (current >= count){
            return arr;
        }
        int[] copy = new int[current];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }


    private static int getMin(int[] matrix, int divisionResult) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] <= min && matrix[i] % 2 == divisionResult){
                min = matrix[i];
                index = i;
            }
        }
        return index;
    }

    private static int getMax(int[] matrix, int divisionResult) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] >= max && matrix[i] % 2 == divisionResult){
                max = matrix[i];
                index = i;
            }
        }
        return index;
    }

    private static void exchangeIndex(int[] matrix, int index) {

        for (int j = 0; j < index + 1; j++) {
            int firstNum = matrix[0];

            for (int k = 0; k < matrix.length - 1; k++) {
                matrix[k] = matrix[k + 1];
            }
            matrix[matrix.length - 1] = firstNum;
        }
    }
}
