package EXAMS.November2015;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class LogParser {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, List<String>>> report = new TreeMap<>();

        Pattern pattern = Pattern.compile("\\\"Project\\\":\\s+\\[\\\"(?<project>.*?)\\\"\\],\\s+\\\"Type\\\":\\s+\\[\\\"(?<type>.*?)\\\"\\],\\s+\\\"Message\\\":\\s+\\[\\\"(?<message>.*?)\\\"\\]");

        String input;
        while (!"END".equalsIgnoreCase(input = sc.readLine())){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String project = matcher.group("project");
                String type = matcher.group("type");
                String message = matcher.group("message");

                report.putIfAbsent(project, new LinkedHashMap<>());
                report.get(project).putIfAbsent(type, new LinkedList<>());
                report.get(project).get(type).add(message);
            }
        }



        report.entrySet().stream()
                .sorted((a,b) -> Integer.compare(b.getValue().size(),a.getValue().size()))
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");
                    System.out.println("Total Errors: " + e.getValue().values().size());
                    System.out.println("Critical: "+ e.getValue().get(e.getKey()));
                });
    }
}
