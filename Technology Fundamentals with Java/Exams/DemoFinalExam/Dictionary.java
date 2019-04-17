package Exams.DemoFinalExam;

import java.io.*;
import java.util.*;

public class Dictionary {
    public static Map<String, List<String>> map;
    public static void main(String[] args) throws IOException{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        map = new TreeMap<>();

        while (true){
            String input = sc.readLine();
            if (input.equals("End")){
                break;
            }else if(input.equals("List")){
                map.forEach((key, value) -> System.out.print(key + " "));
                break;
            }
            String[] data = input.split(" \\| ");

            for (int i = 0; i < data.length; i++) {
                if (data[i].contains(": ")){

                    String[] words = data[i].split(": ");
                    map.putIfAbsent(words[0], new ArrayList<>());
                    map.get(words[0]).add(words[1]);
                }else{
                    String word = data[i];
                    if (map.containsKey(data[i])) {
                        System.out.println(word);
                        map.get(word).stream()
                                .sorted((x,y) -> Integer.compare(y.length(),x.length()))
                                .forEach(x -> System.out.println(" -" + x));
                    }
                }
            }
        }



    }
}
