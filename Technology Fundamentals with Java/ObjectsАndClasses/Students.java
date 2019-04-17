package ObjectsАndClasses;

import java.util.*;

public class Students {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String line;
        while (!"end".equals(line = sc.nextLine())) {
            String[] data = line.split("\\s+");

            Student student = new Student(data[0],
                    data[1],
                    Integer.parseInt(data[2]),
                    data[3]);

            students.add(student);
        }
        String town = sc.nextLine();

        students.stream().filter(e -> e.getCity().equals(town))
                .forEach(s -> System.out.println(s.toString()));
    }

    public static class Student {
        private String firstName;
        private String secondName;
        private int age;
        private String city;

        public Student(String firstName, String secondName, int age, String city) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.city = city;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return String.format("%s %s is %d years old",
                    this.getFirstName(),
                    this.getSecondName(),
                    this.getAge());
        }
    }
}
