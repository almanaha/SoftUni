package MultidimensionArrays.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Internship {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Deque<String> problems = new ArrayDeque<>();
        Deque<String> candidates = new ArrayDeque<>();

        int problemsCount = Integer.parseInt(sc.readLine());
        int candidatesCount = Integer.parseInt(sc.readLine());

        while (problemsCount-- > 0) {
            problems.push(sc.readLine());
        }

        while (candidatesCount-- > 0) {
            String[] data = sc.readLine().split("\\s+");
            if (Character.isUpperCase(data[0].charAt(0)) &&
                    Character.isUpperCase(data[1].charAt(0))) {

                candidates.offer(data[0] + " " + data[1]);
            }
        }

        while (!problems.isEmpty() && candidates.size() > 1) {

            String candidate = candidates.peek();
            String prob = problems.peek();
            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < candidate.length(); i++) {
                sum1 += candidate.charAt(i);
            }
            for (int i = 0; i < prob.length(); i++) {
                sum2 += prob.charAt(i);
            }

            if (sum1 > sum2){
                System.out.println(candidate + " solved " + prob + ".");
                problems.poll();
                candidates.addLast(candidates.pop());
            }else {
                System.out.println(candidate + " failed " + prob+ ".");
                candidates.pop();
                problems.offer(problems.poll());
            }
        }

        if (candidates.size() == 1){
            System.out.println(candidates.pop() + " gets the job!");
        }else {
            int size = candidates.size();
            for (int i = 0; i < size; i++) {
                if (i == size - 1){
                    System.out.print(candidates.pop());
                }else{
                    System.out.print(candidates.pop() + ", ");
                }
            }
        }


    }
}
