package List.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> pokemons = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (!pokemons.isEmpty()){
            int index = Integer.parseInt(sc.nextLine());

            if (index >= 0 && index < pokemons.size()){
                int element = pokemons.get(index);
                sum += element;
                pokemons.remove(index);
                changeElements(pokemons,element);
            }else if (index < 0){
                int element = pokemons.get(0);
                sum += element;
                pokemons.set(0, pokemons.get(pokemons.size() - 1));
                changeElements(pokemons,element);
            }else{
                int element = pokemons.get(pokemons.size() - 1);
                sum += element;
                pokemons.set(pokemons.size() - 1, pokemons.get(0));
                changeElements(pokemons,element);
            }
        }
        System.out.println(sum);
    }

    public static void changeElements(List<Integer> pokemons , int element) {
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i) <= element){
                pokemons.set(i, pokemons.get(i) + element);
            }else{
                pokemons.set(i, pokemons.get(i) - element);
            }
        }
    }
}
