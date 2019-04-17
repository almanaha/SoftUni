package Exams.October2018PartTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoreWars2 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> works = new LinkedHashMap<>();
        works.put("dishes", 0);
        works.put("house", 0);
        works.put("laundry", 0);

        Pattern dishesP = Pattern.compile("(?<=<)([a-z0-9]+)(?=>)");
        Pattern houseP = Pattern.compile("(?<=\\[)([A-Z0-9]+)(?=\\])");
        Pattern laundryP = Pattern.compile("(?<=\\{)(.*?)(?=})");
        Pattern digits = Pattern.compile("\\d");

        String input;
        while (!"wife is happy".equals(input = sc.readLine())){
            Matcher dishesM = dishesP.matcher(input);
            Matcher houseM = houseP.matcher(input);
            Matcher laundryM = laundryP.matcher(input);

            if (dishesM.find()){
                Matcher dig = digits.matcher(dishesM.group(0));
                while (dig.find()){
                    int num = Integer.parseInt(dig.group());
                    works.put("dishes", works.get("dishes") + num);
                }
            }
            if (houseM.find()){
                Matcher dig = digits.matcher(houseM.group(0));
                while (dig.find()){
                    int num = Integer.parseInt(dig.group());
                    works.put("house", works.get("house") + num);
                }
            }
            if (laundryM.find()){
                Matcher dig = digits.matcher(laundryM.group(0));
                while (dig.find()){
                    int num = Integer.parseInt(dig.group());
                    works.put("laundry", works.get("laundry") + num);
                }
            }
        }
        for (Map.Entry<String, Integer> key : works.entrySet()) {
            if (key.getKey().equals("dishes")){
                System.out.println("Doing the dishes - " + key.getValue()+ " min.");
            }else if (key.getKey().equals("house")){
                System.out.println("Cleaning the house - " + key.getValue()+ " min.");
            }else{
                System.out.println("Doing the laundry - " + key.getValue()+ " min.");
            }
        }
        int total = works.values().stream().reduce((sum,y) -> sum += y).get();
        System.out.println("Total - " + total + " min.");

    }
}
