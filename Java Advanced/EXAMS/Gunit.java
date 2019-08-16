package EXAMS;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Gunit {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, List<String>>> classesDatabase = new LinkedHashMap<>();

        Pattern regex = Pattern.compile("^([A-Z][a-zA-Z0-9]+) \\| ([A-Z][a-zA-Z0-9]+) \\| ([A-Z][a-zA-Z0-9]+)$");

        String input;
        while (!"It's testing time!".equals(input = sc.readLine())) {
            Matcher matcher = regex.matcher(input);
            if (matcher.find()) {
                String className = matcher.group(1);
                String methodName = matcher.group(2);
                String unitTestName = matcher.group(3);

                if (classesDatabase.containsKey(className)) {
                    Map<String, List<String>> currentMethods = classesDatabase.get(className);

                    if (currentMethods.containsKey(methodName)) {

                        List<String> currentUnitTests = currentMethods.get(methodName);

                        if (!currentUnitTests.contains(unitTestName)) {
                            currentUnitTests.add(unitTestName);
                        }
                    } else {
                        List<String> newUnitTests = new ArrayList<>();
                        newUnitTests.add(unitTestName);
                        currentMethods.put(methodName, newUnitTests);
                    }
                } else {

                    Map<String, List<String>> newMethods = new LinkedHashMap<>();
                    List<String> newUnitTests = new ArrayList<>();

                    newUnitTests.add(unitTestName);
                    newMethods.put(methodName, newUnitTests);
                    classesDatabase.put(className, newMethods);
                }
            }
        }

        Map<String, Map<String, List<String>>> sortedClasses =
                classesDatabase.entrySet().stream()
                        .sorted((firstClass, secondClass) -> {
                            Integer result = Integer.compare(
                                    getAllUnitTests(secondClass.getValue().values()).size(),
                                    getAllUnitTests(firstClass.getValue().values()).size());

                            if (result == 0) {
                                result = Integer.compare(firstClass.getValue().keySet().size(), secondClass.getValue().keySet().size());
                                if (result == 0) {
                                    result = firstClass.getKey().compareTo(secondClass.getKey());
                                }
                            }
                            return result;
                        }).collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (x, y) -> {
                                    throw new AssertionError();
                                },
                                LinkedHashMap::new));

        for (Map.Entry<String, Map<String, List<String>>> entryClass : sortedClasses.entrySet()) {
            System.out.println(entryClass.getKey() + ":"); //Printing the class name

            Map<String, List<String>> sortedMethods = entryClass.getValue().entrySet().stream()
                    .sorted((firstMethod, secondMethod) -> {
                        Integer result =
                                Integer.compare(
                                        secondMethod.getValue().size(),
                                        firstMethod.getValue().size());

                        if (result == 0) {
                            result = firstMethod.getKey().compareTo(secondMethod.getKey());
                        }

                        return result;
                    })
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (x, y) -> {
                                throw new AssertionError();
                            },
                            LinkedHashMap::new));

            for (Map.Entry<String, List<String>> entryMethod : sortedMethods.entrySet()) {
                System.out.println(String.format("##%s", entryMethod.getKey()));

                List<String> sortedUnitTests = entryMethod
                        .getValue()
                        .stream()
                        .sorted(Comparator.comparingInt(String::length)
                                .thenComparing(firstUnitTest -> firstUnitTest))
                        .collect(Collectors.toCollection(ArrayList::new));

                for (String unitTest : sortedUnitTests) {
                    System.out.println(String.format("####%s", unitTest));
                }
            }
        }
    }

    private static List<String> getAllUnitTests(Collection<List<String>> unitTests) {

        List<String> resultSet = new ArrayList<>();

        for (List<String> innerSet : unitTests) {
            resultSet.addAll(innerSet);
        }
        return resultSet;
    }
}
