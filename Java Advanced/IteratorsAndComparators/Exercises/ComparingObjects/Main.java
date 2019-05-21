package IteratorsAndComparators.Exercises.ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> peopleByEquality = new TreeSet<>();
        Set<Person> peopleByHash = new HashSet<>();

        int n = Integer.parseInt(sc.readLine());
        while (n-- > 0) {
            String[] data = sc.readLine().split("\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1].trim()));
            peopleByEquality.add(person);
            peopleByHash.add(person);
        }
        System.out.println(peopleByEquality.size());
        System.out.println(peopleByHash.size());

    }
}
