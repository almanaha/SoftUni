package List.Exercises;

import java.util.*;
import java.util.stream.*;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> arrays = Arrays.stream(sc.nextLine().split("\\|"))
                .collect(Collectors.toList());
        Collections.reverse(arrays);
        String toPrint = arrays.toString().replaceAll("[\\]\\[,]", "");
        toPrint = toPrint.replaceAll("\\s+", " ");

        System.out.println(toPrint);
    }
}
