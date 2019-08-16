package EXAMS.February2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Deque<List<Integer>> earth = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();

        int n = Integer.parseInt(sc.readLine());

        while (n-- > 0) {
            earth.addLast(
                    Arrays.stream(sc.readLine().split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
        }

        while (!earth.isEmpty()) {
            List<Integer> currentNumbers = earth.pop();
            int wave = currentNumbers.get(0);

            for (int i = 1; i < currentNumbers.size(); i++) {
                if (wave < currentNumbers.get(i)) {
                    earth.addLast(currentNumbers.subList(i, currentNumbers.size()));
                    break;
                }
            }
            output.add(wave);
        }

        System.out.println(output.size());
        output.forEach(e -> System.out.print(e + " "));
    }
}
