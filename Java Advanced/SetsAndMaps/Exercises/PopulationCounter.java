package SetsAndMaps.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();

        String input;
        while (!"report".equals(input = sc.nextLine())) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);

            Map<String, Long> cities = new LinkedHashMap<>();
            if (countries.containsKey(country)) {
                cities = countries.get(country);
            }

            cities.put(city, population);
            countries.put(country, cities);
        }

        Map<String, Map<String, Long>> sortedCountries = countries.entrySet()
                .stream().sorted((k1, k2) -> {
                    long population1 = k1.getValue()
                            .values()
                            .stream()
                            .mapToLong(Long::valueOf)
                            .sum();
                    long population2 = k2.getValue()
                            .values()
                            .stream()
                            .mapToLong(Long::valueOf)
                            .sum();
                    return Long.compare(population2, population1); // descending order
                }).collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Long>> country : sortedCountries.entrySet()) {
            StringBuilder citiesResult = new StringBuilder();
            long totalPopulation = 0;
            Map<String, Long> sortedCities = country.getValue()
                    .entrySet()
                    .stream()
                    .sorted((a,b) -> Long.compare(b.getValue(),a.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

            for (Map.Entry<String, Long> city : sortedCities.entrySet()) {
                citiesResult.append("=>").append(city.getKey()).append(": ").append(city.getValue()).append("\n");
                totalPopulation += city.getValue();
            }
            System.out.printf("%s (total population: %d)%n",
                    country.getKey(),totalPopulation);
            System.out.print(citiesResult);
        }
    }
}
