package List;

import java.util.*;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int length = numbers.size();

        for (int i = 0; i < length / 2; i++) {
            numbers.set(i,numbers.get(i)
                    + numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }
        for (Integer x : numbers) {
            System.out.print(x + " ");

        }
    }
}
