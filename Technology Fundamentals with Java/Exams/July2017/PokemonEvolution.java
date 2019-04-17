package Exams.July2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PokemonEvolution {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> pokemons = new LinkedHashMap<>();
        String input;
        while (!"wubbalubbadubdub".equals(input = sc.readLine())){
            String[] data = input.split(" -> ");
            if (data.length > 1){
                pokemons.putIfAbsent(data[0], new ArrayList<>());
                String cmd = data[1] + " <-> " + data[2];
                pokemons.get(data[0]).add(cmd);
            }else if(pokemons.containsKey(data[0])){
                System.out.println("# " + data[0]);
                pokemons.get(data[0]).forEach(System.out::println);
            }
        }
        pokemons.forEach((key,value) -> {
            System.out.println("# " + key);
            value.stream().sorted((first,second) -> {
                String f = first.split(" <-> ")[1];
                String s = second.split(" <-> ")[1];
                return Integer.parseInt(s) - Integer.parseInt(f);
            }).forEach(System.out::println);
        });
    }
}
