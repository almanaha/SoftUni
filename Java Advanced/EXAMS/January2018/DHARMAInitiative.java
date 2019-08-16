package EXAMS.January2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DHARMAInitiative {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> stationsPurpose = new HashMap<>();
        stationsPurpose.put("Hydra", "The Hydra station: Zoological Research.");
        stationsPurpose.put("Arrow", "The Arrow station: Development of defensive strategies, and Intelligence gathering.");
        stationsPurpose.put("Flame", "The Flame station: Communication.");
        stationsPurpose.put("Pearl", "The Pearl station: Psychological Research and/or Observation.");
        stationsPurpose.put("Orchid", "The Orchid station: Space-time manipulation research, disguised as a Botanical station.");

        Map<String, Map<String, String>> dharma = new TreeMap<>();
        dharma.put("Hydra", new LinkedHashMap<>());
        dharma.put("Arrow", new LinkedHashMap<>());
        dharma.put("Flame", new LinkedHashMap<>());
        dharma.put("Pearl", new LinkedHashMap<>());
        dharma.put("Orchid", new LinkedHashMap<>());



        String input;
        while (!"Recruit".equals(input = sc.readLine())) {
            String[] data = input.split(":");
            String station = data[2];

            if (dharma.containsKey(station)) {
                boolean isUnique = true;

                for (Map<String, String> worker : dharma.values()) {
                    if (worker.values().equals(data[1])){
                        isUnique = false;
                        break;
                    }
                }
                if (isUnique) {
                    dharma.get(station).putIfAbsent(data[0], data[1]);
                }
            }
        }

        input = sc.readLine();
        if (input.equals("DHARMA Initiative")) {
            dharma.entrySet().stream()
                    .sorted((x, y) -> {
                        int workersX = x.getValue().values().size();
                        int workersY = y.getValue().values().size();
                        return Integer.compare(workersY, workersX);
                    })
                    .forEach(e -> System.out.printf("The %s has %d DHARMA recruits in it.",
                            e.getKey(),
                            e.getValue().values().size()).println());
        } else {
            if (dharma.containsKey(input)) {
                if (dharma.get(input).size() == 0) {
                    System.out.println("No recruits.");
                } else {
                    System.out.println(stationsPurpose.get(input));
                    dharma.get(input).entrySet().stream()
                            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                            .forEach(e -> System.out.printf("###%s - %s",
                                    e.getKey(),
                                    e.getValue()).println());
                }
            } else {
                System.out.println("DHARMA Initiative does not have such a station!");
            }
        }
    }
}
