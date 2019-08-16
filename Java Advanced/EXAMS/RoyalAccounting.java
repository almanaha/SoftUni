package EXAMS;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class RoyalAccounting {

    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<String> allEmployees = new ArrayList<>();
        Map<String, LinkedHashMap<String, Double[]>> employeesByTeamDatabase = new LinkedHashMap<>();

        String stringPattern = "^([a-zA-Z]+)\\;(\\-?\\d+)\\;(\\-?\\d+\\.?\\d*)\\;([a-zA-Z]+)$";

        Pattern regexPattern = Pattern.compile(stringPattern);

        String inputLine;
        while(!"Pishi kuf i da si hodim".equalsIgnoreCase(inputLine = sc.readLine())) {
            Matcher matcher = regexPattern.matcher(inputLine);
            if(matcher.find()) {
                String teamName = matcher.group(4);
                String employeeName = matcher.group(1);
                Double workHoursPerDay = Double.parseDouble(matcher.group(2));
                Double dailyPayment = Double.parseDouble(matcher.group(3));
                if(!allEmployees.contains(employeeName)) {
                    if(employeesByTeamDatabase.containsKey(teamName)) {
                        Double[] employeeCharacteristics = new Double[] { workHoursPerDay, dailyPayment };
                        LinkedHashMap<String, Double[]> currentEmployees = employeesByTeamDatabase.get(teamName);
                        currentEmployees.put(employeeName, employeeCharacteristics);
                    }
                    else {
                        Double[] employeeCharacteristics = new Double[] { workHoursPerDay, dailyPayment };
                        LinkedHashMap<String, Double[]> currentEmployees = new LinkedHashMap<>();
                        currentEmployees.put(employeeName, employeeCharacteristics);
                        employeesByTeamDatabase.put(teamName, currentEmployees);
                    }
                    allEmployees.add(employeeName);
                }
            }
        }

        LinkedHashMap<String, LinkedHashMap<String, Double[]>> sortedEmployeeDatabase =
                employeesByTeamDatabase.entrySet().stream()
                        .sorted((firstTeam, secondTeam) -> {
                                    Double firstTeamMoney = firstTeam
                                                    .getValue()
                                                    .values()
                                                    .stream()
                                                    .collect(Collectors.summingDouble(employeeCredentials -> ((employeeCredentials[0].doubleValue() * employeeCredentials[1].doubleValue()) / 24) * 30));

                                    Double secondTeamMoney =
                                            secondTeam
                                                    .getValue()
                                                    .values()
                                                    .stream()
                                                    .collect(Collectors.summingDouble(employeeCredentials -> ((employeeCredentials[0].doubleValue() * employeeCredentials[1].doubleValue()) / 24) * 30));

                                    Integer result = secondTeamMoney.compareTo(firstTeamMoney);
                                    return result;
                                })
                        .collect(
                                Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (x, y) -> { throw new AssertionError(); },
                                        LinkedHashMap::new
                                )
                        );

        String employeeOutputPadding = "$$$";
        for (Map.Entry<String, LinkedHashMap<String, Double[]>> currentTeam : sortedEmployeeDatabase.entrySet()) {
            System.out.println(String.format("Team - %s", currentTeam.getKey()));
            LinkedHashMap<String, Double[]> sortedEmployees =
                    currentTeam
                            .getValue()
                            .entrySet()
                            .stream()
                            .sorted(
                                    (firstEmployee, secondEmployee) -> {

                                        Integer result = secondEmployee.getValue()[0].compareTo(firstEmployee.getValue()[0]);

                                        if(result.equals(0)) {

                                            Double firstEmployeeDailyIncome = ((firstEmployee.getValue()[0] * firstEmployee.getValue()[1]) / 24);
                                            Double secondEmployeeDailyIncome = ((secondEmployee.getValue()[0] * secondEmployee.getValue()[1]) / 24);

                                            result = secondEmployeeDailyIncome.compareTo(firstEmployeeDailyIncome);

                                            if(result.equals(0)) {
                                                result = firstEmployee.getKey().compareTo(secondEmployee.getKey());
                                            }
                                        }

                                        return result;
                                    })
                            .collect(
                                    Collectors.toMap(
                                            Map.Entry::getKey,
                                            Map.Entry::getValue,
                                            (x, y) -> { throw new AssertionError(); },
                                            LinkedHashMap::new
                                    )
                            );


            for (Map.Entry<String, Double[]> currentEmployee : sortedEmployees.entrySet()) {
                System.out.println(
                        String.format("%s%s - %s - %f",
                                employeeOutputPadding,
                                currentEmployee.getKey(),
                                currentEmployee.getValue()[0].intValue(),
                                (currentEmployee.getValue()[0] * currentEmployee.getValue()[1].doubleValue()) / 24));
            }
        }
    }
}

class Employee {
    private String name;
    private Double workHoursPerDay;
    private Double dailyPayment;

    Employee(String name, Double workHoursPerDay, Double dailyPayment) {
        this.name = name;
        this.workHoursPerDay = workHoursPerDay;
        this.dailyPayment = dailyPayment;
    }

    Double monthlyPayment() {
        return (this.workHoursPerDay * this.dailyPayment) / 24.0;
    }

    public Double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    public String getName() {
        return this.name;
    }

}
