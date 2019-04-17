package ObjectsАndClasses.Exercises.Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Student> university = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0){
            String[] data = sc.nextLine().split("\\s+");
            Student student = new Student(data[0],data[1],Double.parseDouble(data[2]));
            university.add(student);
        }

        university.stream()
                .sorted((s1,s2) ->
                        Double.compare(s2.getGrade(),s1.getGrade()))
                .forEach(e -> System.out.println(e.toString()));
    }
}
