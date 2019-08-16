package EXAMS.August2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Agents {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


        Map<String, Double> bombfield = new HashMap<>();
        List<String> agents = new ArrayList<>();

        String input;
        while (!"registration".equals(input = sc.readLine())) {
            if (input.startsWith("#")) {
                String[] data = input.split(":");
                bombfield.putIfAbsent(data[0], Double.parseDouble(data[1]));
            } else {
                agents.add(input);
            }
        }

        Map<String, Map<String, Double>> agentsAssigned = new LinkedHashMap<>();

        while (!"operate".equals(input = sc.readLine())) {
            String[] data = input.split("->");
            String agent;
            String mission;

            switch (data[0]) {
                case "assign":
                    agent = data[1];
                    mission = data[2];

                    if (bombfield.containsKey(mission)) {
                        agentsAssigned.putIfAbsent(agent, new LinkedHashMap<>());
                        agentsAssigned.get(agent).putIfAbsent(mission, bombfield.get(mission));
                    }
                    break;
                case "abort":
                    mission = data[1];
                    for (Map<String, Double> missions : agentsAssigned.values()) {
                        missions.remove(mission);
                    }
                    break;
                case "change":
                    agent = data[1];
                    String agent2 = data[2];
                    Map<String, Double> oldValue = agentsAssigned.get(agent);
                    Map<String, Double> newValue = agentsAssigned.get(agent2);
                    agentsAssigned.replace(agent, oldValue, newValue);
                    agentsAssigned.replace(agent2, newValue, oldValue);
                    break;
            }
        }

        agentsAssigned.entrySet().stream()
                .filter(a -> !a.getValue().isEmpty())
                .sorted((x, y) -> Double.compare(
                        y.getValue().values().stream().reduce((a, b) -> a += b).get(),
                        x.getValue().values().stream().reduce((a, b) -> a += b).get()))
                .forEach(e -> {
                    double total = e.getValue().values().stream().reduce((x, y) -> x += y).get();
                    System.out.printf("Agent: %s - Total Rating: %.2f",
                            e.getKey(),
                            total
                    ).println();
                    e.getValue().entrySet().stream()
                            .sorted((x, y) -> Double.compare(y.getValue(), x.getValue()))
                            .forEach(x -> System.out.printf("- %s -> %.2f", x.getKey(), x.getValue()).println());
                });
    }
}
