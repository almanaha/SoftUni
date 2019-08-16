package EXAMS.August2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class Agency {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


        Deque<String> id = new ArrayDeque<>();
        Deque<String> agents = new ArrayDeque<>();

        Arrays.stream(sc.readLine().split("\\s+"))
                .forEach(id::push);
        Arrays.stream(sc.readLine().split("\\s+"))
                .forEach(agents::offer);

        String input;
        while (!"stop".equals(input = sc.readLine())) {
            String[] data = input.split("\\s+");
            switch (data[0]) {
                case "add-ID":
                    id.push(data[1]);
                    break;
                case "add-agent":
                    agents.offer(data[1]);
                    break;
                case "remove-ID":
                    System.out.println(id.pop() + " has been removed.");
                    break;
                case "remove-agent":
                    System.out.println(agents.removeLast() + " has left the queue.");
                    break;
                case "sort-ID":
                    id = id.stream()
                            .sorted(Comparator.reverseOrder())
                            .collect(Collectors.toCollection(ArrayDeque::new));

                    break;
            }
        }

        while (!agents.isEmpty()){
            if (!id.isEmpty()){
                System.out.println(agents.poll() + " takes ID number: " + id.pop());
            }else{
                System.out.println(agents.poll() + " does not have an ID.");
            }
        }
        if (!id.isEmpty()){
            System.out.println("No more agents left.");
            while (!id.isEmpty()){
                System.out.println("ID number: " + id.pop());
            }
        }
    }
}
