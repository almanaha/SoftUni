package List;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SumAdjacentNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))){
                numbers.set(i,(numbers.get(i) + numbers.get(i + 1)));
                numbers.remove(i + 1);
                i--; // reset the loop
            }
        }
        for (Double x : numbers) {
            System.out.print(new DecimalFormat("0.#").format(x) + " ");
        }

    }
}
