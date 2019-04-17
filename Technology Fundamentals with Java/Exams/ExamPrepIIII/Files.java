package Exams.ExamPrepIIII;

import java.util.*;

public class Files {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> files = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            files.add(sc.nextLine());
        }
        String filter = sc.nextLine();
        String[] data = filter.split(" in ");
        String extension = "." + data[0];
        String root = data[1] + "\\";

        boolean isEmpty = true;
        Map<String, Integer> fileSize = new HashMap<>();
        for (String file : files) {
            String[] parts = file.split(";");
            String path = parts[0];

            if (path.startsWith(root) && path.endsWith(extension)) {
                isEmpty = false;
                String[] tokens = path.split("\\\\");
                int size = Integer.parseInt(parts[1]);
                fileSize.put(tokens[tokens.length - 1], size);
            }
        }
        if (isEmpty) {
            System.out.println("No");
        } else {
            fileSize.entrySet().stream()
                    .sorted((x, y) -> Integer.compare(y.getValue(), x.getValue()) == 0 ?
                            x.getKey().compareTo(y.getKey()) :
                            Integer.compare(y.getValue(), x.getValue()))
                    .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue() + " KB"));
        }
    }
}
