package ObjectsАndClasses.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class OpinionPoll { // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] data = sc.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person p = new Person(name, age);
            people.add(p);
        }

        people = people.stream().filter(p -> p.getAge() > 30)
                .collect(Collectors.toCollection(ArrayList::new));

        people.stream().sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.toString()));

//  or like this -->
//        people
//                .stream()
//                .filter(p -> p.getAge() > 30)
//                .sorted(Comparator.comparingInt(Person::getName))
//                .forEach(p -> System.out.println(p.toString()));
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.getName(), this.getAge());
    }
}


