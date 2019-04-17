package ObjectsАndClasses.Exercises;

import java.util.*;

public class OrderByAge {
    static class Person{
        private String name;
        private String ID;
        private int age;

        public Person(String name, String ID, int age) {
            this.name = name;
            this.ID = ID;
            this.age = age;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.",
                    this.name,this.ID,this.age);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input;
        while (!"End".equals(input = sc.nextLine())){
            String[] data = input.split("\\s+");

            String name = data[0];
            String id = data[1];
            int age = Integer.parseInt(data[2]);

            Person person = new Person(name,id,age);
            people.add(person);
        }
        people.stream().sorted(Comparator.comparing(Person::getAge))
                .forEach(p -> System.out.println(p.toString()));

    }

}
