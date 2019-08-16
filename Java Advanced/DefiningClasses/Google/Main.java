package DefiningClasses.Google;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!"End".equals(line = sc.readLine())) {
            String[] data = line.split("\\s+");
            String personName = data[0];
            String objectName = data[1];

            Person person = Person.persons.get(personName);

            if (person == null) {
                person = new Person(personName);
            }

            switch (objectName) {
                case "company":
                    person.setCompany(new Company(data[2], data[3], Double.parseDouble(data[4])));
                    break;
                case "pokemon":
                    person.addPokemon(data[2], data[3]);
                    break;
                case "parents":
                    person.addParent(data[2], data[3]);
                    break;
                case "children":
                    person.addChild(data[2], data[3]);
                    break;
                case "car":
                    person.setCar(new Car(data[2], Integer.parseInt(data[3])));
                    break;
            }
        }

        Person.persons.get(sc.readLine()).printInfo();
    }
}
