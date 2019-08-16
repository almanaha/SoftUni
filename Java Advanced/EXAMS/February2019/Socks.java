package EXAMS.February2019;

import java.util.*;

public class Socks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Deque ->> Stack and Queue
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(left::push); // push -> stack

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(right::offer); // offer -> queue

        List<Integer> pairs = new ArrayList<>();

        while (left.size() > 0 && right.size() > 0) {
            int leftSock = left.pop();
            //int leftSock = left.peek(); stack peeks last index
            int rigthSock = right.peek(); // queue peeks index 0

            if (leftSock > rigthSock) {
                right.poll();
                pairs.add(leftSock + rigthSock);
            } else if (rigthSock == leftSock) {
                right.poll();
                left.push(leftSock + 1);
            }
        }

        int maxPair = pairs.stream().max(Comparator.comparingInt(f -> f)).get();
        System.out.println(maxPair);
        pairs.forEach(p -> System.out.print(p + " "));
    }
}
