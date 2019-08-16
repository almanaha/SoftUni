package DefiningClasses.OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String[] data = sc.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person p = new Person(name, age);
            people.add(p);

        }

        people.stream().sorted(Comparator.comparing(Person::getName))
        .filter(p -> p.getAge() > 30)
        .forEach(p -> System.out.printf("%s - %d%n",p.getName(),p.getAge()));
    }
}
