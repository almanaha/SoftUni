package EXAMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stones = new ArrayDeque<>();
        Arrays.stream(sc.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stones::offer);

        int gold = 0;

        String input;
        while (!"Revision".equalsIgnoreCase(input = sc.readLine())) {
            String[] data = input.split("\\s+");

            switch (data[0]) {
                case "Apply":
                    int acid = Integer.parseInt(data[2]);
                    while (acid-- > 0 && !stones.isEmpty()){

                        int element = stones.poll();
                        if (--element <= 0){
                            gold++;
                        }else {
                            stones.addLast(element);
                        }
                    }

                    break;
                case "Air":
                    int label = Integer.parseInt(data[2]);
                    if (gold <= 0){
                        break;
                    }
                    gold--;
                    stones.addLast(label);
                    break;
                default:
                    print(stones, gold);
                    break;
            }
        }
        print(stones, gold);
    }

    private static void print(Deque<Integer> stones, int gold) {
        while (!stones.isEmpty()) {
            System.out.print(stones.pop() + " ");
        }
        System.out.println(System.lineSeparator() + gold);
    }
}
