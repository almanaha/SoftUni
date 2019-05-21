package StacksAndQueues.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int n = Integer.parseInt(sc.readLine());
        int[] plants = Arrays.stream(sc.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] daysPlantsDie = new int[n];
        Deque<Integer> prevPlantsIndexes = new ArrayDeque<>();
        prevPlantsIndexes.push(0);

        // starts from 1 , because we already push 0 in the stack
        for (int i = 1; i < n; i++) {
            int lastDay = 0;
            // with prevPlants.peek() we get the index of the plant
            while (prevPlantsIndexes.size() > 0 && plants[prevPlantsIndexes.peek()] >= plants[i]){
                //the day current plant dies
                lastDay = Math.max(lastDay, daysPlantsDie[prevPlantsIndexes.pop()]);
            }

            if (prevPlantsIndexes.size() > 0){
                daysPlantsDie[i] = lastDay + 1;
            }
            prevPlantsIndexes.push(i);
        }
        System.out.println(Arrays.stream(daysPlantsDie).max().getAsInt());
    }
}
