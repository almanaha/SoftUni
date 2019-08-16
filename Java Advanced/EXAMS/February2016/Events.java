package EXAMS.February2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Events {

    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^#([a-zA-Z]+):[\\s]*@([a-zA-Z]+)[\\s]*([\\d]{2}:[\\d]{2})$");
        int eventsCount = Integer.parseInt(sc.readLine());

        TreeMap<String, TreeMap<String, String>> eventsByLocation = new TreeMap<>();

        for (int i = 0; i < eventsCount; i++) {
            String event = sc.readLine();
            Matcher m = pattern.matcher(event);

            if (m.find()) {
                String person = m.group(1);
                String location = m.group(2);
                String fullHour = m.group(3);

                int hour = Integer.parseInt(fullHour.split(":")[0]);
                int minutes = Integer.parseInt(fullHour.split(":")[1]);

                if (hour < 0 || hour > 23 || minutes < 0 || minutes > 59) {
                    continue;
                }

                if (eventsByLocation.containsKey(location)) {
                    TreeMap<String, String> people = eventsByLocation.get(location);
                    if (eventsByLocation.get(location).containsKey(person)) {
                        people.replace(person, people.get(person),
                                fullHour + ", " + people.get(person));
                    } else {
                        people.put(person, fullHour);
                    }
                } else {
                    eventsByLocation.putIfAbsent(location, new TreeMap<>());
                    eventsByLocation.get(location).put(person, fullHour);
                }
            }
        }

        String[] cities = sc.readLine().split(",");

        Arrays.sort(cities);

        for (String city : cities) {
            if (eventsByLocation.containsKey(city)) {
                System.out.println(String.format("%s:", city));

                int count = 1;
                for (Map.Entry<String, String> entry : eventsByLocation.get(city).entrySet()) {
                    System.out.println(String.format("%d. %s -> %s",
                            count++,
                            entry.getKey(),
                            entry.getValue()));
                }
            }
        }
    }
}
