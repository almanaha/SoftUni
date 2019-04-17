package ObjectsАndClasses;

import java.util.*;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> words = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Collections.shuffle(words);
        System.out.println(String.join(System.lineSeparator(), words));

        // second way -->

//        while (!words.isEmpty()){
//            Random random = new Random();
//            int index = random.nextInt(words.size());
//            String word = words.get(index);
//            words.remove(index);
//            System.out.println(word);
//        }
    }
}
