package MapsLambdaStreamAPI.Exercises;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //order the companies by the name in ascending order --> TreeMap
        Map<String, List<String>> companies = new TreeMap<>();

        String input;
        while (!"End".equals(input = sc.nextLine())) {
            String[] data = input.split(" -> ");
            String company = data[0];
            String id = data[1];

            if (!companies.containsKey(company)) {
                companies.put(company, new ArrayList<>());
            }
            //cannot have HelloFrance employees with the same id
            if (!companies.get(company).contains(id)) {
                companies.get(company).add(id);
            }


        }

        for (String key : companies.keySet()) {
            System.out.println(key);
            companies.get(key)
                    .forEach(value -> System.out.println("-- " + value));
        }
          //  key.().sort(String::compareTo);
    }
}
