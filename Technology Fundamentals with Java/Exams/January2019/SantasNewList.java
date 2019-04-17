package Exams.January2019;

        import java.util.*;

public class SantasNewList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> childrens = new HashMap<>();
        Map<String, Integer> presents = new LinkedHashMap<>();

        String cmd;
        while (!"END".equals(cmd = sc.nextLine())) {
            String[] data = cmd.split("->");
            if (data.length == 3) {
                String name = data[0];
                String present = data[1];
                int count = Integer.parseInt(data[2]);
                childrens.putIfAbsent(name, 0);
                childrens.put(name, childrens.get(name) + count);
                presents.putIfAbsent(present, 0);
                presents.put(present, presents.get(present) + count);
            } else {
                childrens.remove(data[1]);
            }
        }
        System.out.println("Children:");
        childrens.entrySet().stream()
                .sorted((x, y) -> y.getValue().compareTo(x.getValue()) == 0 ?
                        x.getKey().compareTo(y.getKey()) :
                        Integer.compare(y.getValue(),x.getValue()))
                .forEach(e -> System.out.printf("%s -> %d\n", e.getKey(),e.getValue()));

        System.out.println("Presents:");
        presents.forEach((key, value) -> System.out.printf("%s -> %d\n", key, value));
    }
}
