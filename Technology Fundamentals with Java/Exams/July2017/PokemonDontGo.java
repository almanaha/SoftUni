package Exams.July2017;

import java.util.*;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int total = 0;
        while (numbers.size() > 0) {
            int index = Integer.parseInt(sc.nextLine());
            int n = 0;

            if (index < 0) { // remove first element , and add the last to it`s place
                n = numbers.get(0);
                numbers.set(0, numbers.get(numbers.size() - 1));
            } else if (index > numbers.size() - 1) {
                n = numbers.get(numbers.size() - 1);
                numbers.set(numbers.size() - 1, numbers.get(0));
            } else {
                n = numbers.get(index);
                numbers.remove(index);
            }
            total += n;
            IncreaseOrDecrease(numbers, n);
        }
        System.out.println(total);
    }

    private static void IncreaseOrDecrease(List<Integer> numbers, int n) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) <= n){
                numbers.set(i, numbers.get(i) + n); // increase
            }else{
                numbers.set(i, numbers.get(i) - n); // decrease
            }
        }
    }
}
