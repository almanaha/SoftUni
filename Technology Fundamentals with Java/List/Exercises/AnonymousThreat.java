package List.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> elements = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String cmd = sc.nextLine();

        while (!cmd.equals("3:1")) {
            String[] tokens = cmd.split("\\s+");
            String command = tokens[0];
            int start = Math.min(Integer.parseInt(tokens[1]), elements.size() - 1);
            start = Math.max(0, start);
            int end = Integer.parseInt(tokens[2]);

            List<String> result = new ArrayList<>();

            if (command.equals("merge")) {

                end = Math.min(Integer.parseInt(tokens[2]), elements.size() - 1);
                end = Math.max(0, end);

                if (start > 0) {
                    result.addAll(elements.subList(0, start));
                }
                String merged = elements.subList(start, end + 1)
                        .stream()
                        .reduce((res, el) -> res + el)
                        .get();

                result.add(merged);

                if ((end + 1) < elements.size()) {
                    result.addAll(elements.subList(end + 1, elements.size()));
                }
                elements = result;

            } else {
                String element = elements.get(start);
                end = Math.min(end, element.length());
                int symbols = element.length() / end;
                int lastElementLengh = symbols + element.length() % end;
                int parts = element.length() - lastElementLengh;
                String lastElement = element.substring(element.length() - lastElementLengh);
                element = element.substring(0, element.length() - lastElementLengh);

                for (int i = 0; i < parts && element.length() > 0; i++) {
                    result.add(element.substring(0, symbols));
                    element = element.substring(symbols);
                }
                if (!element.isEmpty()) {
                    result.add(element);

                }
                if (!lastElement.isEmpty()) {
                    result.add(lastElement);
                }
                elements.remove(start);
                elements.addAll(start, result);
            }

            cmd = sc.nextLine();
        }

        elements.forEach(e -> System.out.print(e + " "));
    }
}
