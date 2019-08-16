package EXAMS.February2019;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ClubParty {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int hallCapacity = Integer.parseInt(sc.readLine());
        String[] hallsAndPeople = sc.readLine().split(" ");

        Deque<String> halls = new ArrayDeque<>();
        List<Integer> currentHallReservations = new ArrayList<>();

        for (int i = hallsAndPeople.length - 1; i >= 0; i--) {
            String current = hallsAndPeople[i];

            if (Character.isDigit(current.charAt(0))) {
                if (halls.isEmpty()) {
                    continue;
                }

                int currentReservation = Integer.parseInt(current);

                if (currentReservation > hallCapacity) {
                    continue;
                }

                int sum = currentHallReservations.stream().mapToInt(x -> x).sum();
                if (sum + currentReservation <= hallCapacity) {
                    currentHallReservations.add(currentReservation);
                } else {
                    printHall(halls.poll(), currentHallReservations);
                    currentHallReservations.clear();
                    i++;
                }
            } else {
                halls.offer(current);
            }
        }
    }

    private static void printHall(String hall, List<Integer> currentHallReservations) {
        System.out.print(hall);
        System.out.print(" -> ");
        System.out.println(currentHallReservations
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
