package SetsAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static String continent;
    public static String country;
    public static String city;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Map<String, List<String>>> data = new LinkedHashMap<>();

        int rowCount = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < rowCount; i++) {
            String[] input = sc.nextLine().split(" ");
            continent = input[0];
            country = input[1];
            city = input[2];

            if (data.containsKey(continent)) {

                Map<String, List<String>> countries = data.get(continent);
                if (countries.containsKey(country)) {
                    countries.get(country).add(city);
                } else {
                    List<String> cities = new ArrayList<>();
                    cities.add(city);
                    countries.put(country, cities);
                }
                data.put(continent, countries);

            } else {
                Map<String, List<String>> countries = new LinkedHashMap<>();
                List<String> cities = new ArrayList<>();
                cities.add(city);
                countries.put(country, cities);
                data.put(continent, countries);
            }
        }

        data.entrySet()
                .stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");
                    e.getValue()
                            .entrySet()
                            .stream()
                            .forEach(c -> {
                                System.out.printf("  %s -> ", c.getKey());
                                System.out.println(String.join(", ", c.getValue()));
                            });
                });

    }
}
