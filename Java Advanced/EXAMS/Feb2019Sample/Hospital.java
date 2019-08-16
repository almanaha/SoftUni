import java.io.*;
import java.util.*;

public class Hospital {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String[]> departments = new HashMap<>();
        Map<String, TreeSet<String>> doctors = new HashMap<>();

        String data;
        while (!"Output".equals(data = sc.readLine())) {
            String[] info = data.split("\\s+");

            String department = info[0];
            String doctor = info[1] + " " + info[2];
            String patient = info[3];

            departments.putIfAbsent(info[0], new String[60]);
            doctors.putIfAbsent(doctor, new TreeSet<>());

            for (int i = 0; i < departments.get(department).length; i++) {
                if (departments.get(department)[i] == null) { // empty bed
                    departments.get(department)[i] = patient;
                    doctors.get(doctor).add(patient);
                    break;
                }
            }

        }

        while (!"End".equals(data = sc.readLine())) {
            String[] info = data.split("\\s+");

            if (info.length == 1) { // department only
                String department = info[0];

                for (int i = 0; i < departments.get(department).length; i++) {
                    if (departments.get(department)[i] != null) {
                        System.out.println(departments.get(department)[i]);
                    }

                }

            } else if (info.length == 2) {
                if (Character.isDigit(info[1].charAt(0))) {
                    String department = info[0];
                    int room = Integer.parseInt(info[1]) - 1;

                    int startIndex = room * 3;

                    Arrays.stream(departments.get(department))
                            .skip(startIndex)
                            .limit(3)
                            .filter(Objects::nonNull)
                            .sorted(String::compareTo)
                            .forEach(System.out::println);
                } else {
                    String doctor = info[0] + " " + info[1];
                    doctors.get(doctor).forEach(System.out::println);
                }
            }
        }
    }
}