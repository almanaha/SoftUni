package MapsLambdaStreamAPI;
import java.util.*;
public class Largest3Numbers {
    public static void main(String[] args) {
        Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(e -> System.out.print(e + " "));
    }
}
