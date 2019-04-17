package ObjectsАndClasses;
import java.util.*;

public class Students2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String line;
        while (!"end".equals(line = sc.nextLine())) {
            String[] data = line.split("\\s+");

            String name1 = data[0];
            String name2 = data[1];
            int age = Integer.parseInt(data[2]);
            String city = data[3];

            Student student = students.stream()
                    .filter(s -> s.getFirstName().equals(name1) &&
                            s.getSecondName().equals(name2))
                    .findFirst()
                    .orElse(null);

            if (student == null){
                Student x = new Student(name1,name2,age,city);
                students.add(x);
            }else{
                // set different information
                student.setFirstName(name1);
                student.setSecondName(name2);
                student.setAge(age);
                student.setCity(city);
            }

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

