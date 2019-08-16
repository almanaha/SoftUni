package EXAMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TheSwanStation {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> theNumbers = Arrays.stream(sc.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> outsiders = Arrays.stream(sc.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        List<Integer> survivors = new LinkedList<>();

        while (true) {
            int first = theNumbers.pop();
            int second = outsiders.pop();
            if (first % second == 0) {
                survivors.add(first);
                if (theNumbers.size() == 1){
                    survivors.add(theNumbers.pop());
                    break;
                }
            } else {
                theNumbers.push(++first);
                outsiders.offer(++second);
            }
        }

        System.out.println(survivors.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
