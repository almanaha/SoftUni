package MapsLambdaStreamAPI.Exercises;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> data = new LinkedHashMap<>();
        String input;
        while (!"report".equals(input = sc.readLine())){

            String[] cmd = input.split("\\|");
            String city = cmd[0];
            String country = cmd[1];
            Long popultaion = Long.parseLong(cmd[2]);
            data.putIfAbsent(country, new LinkedHashMap<>());
            data.get(country).put(city, popultaion);
        }

        data.entrySet().stream()
                .sorted((x,y) -> {
                   // x.getValue().values().stream()
                    // .collect(Collectors.summarizingLong(Long::longValue)).getSum()
                    long p1 = x.getValue().values().stream().mapToLong(Long::longValue).sum();
                    long p2 = y.getValue().values().stream().mapToLong(Long::longValue).sum();
                    return Long.compare(p2,p1); // descending order
                })
                .forEach(country -> {
                    long population = country.getValue().values().stream().mapToLong(Long::longValue).sum();
                    System.out.printf("%s (total population: %d)\n",country.getKey(),population);
                    country.getValue().entrySet().stream()
                            .sorted((x,y) -> y.getValue().compareTo(x.getValue()))
                            .forEach(city -> System.out.println("=>" + city.getKey() + ": " + city.getValue()));
                });
    }
}
