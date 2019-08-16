package DefiningClasses.Google;

import java.util.*;

class Person {
    static HashMap<String, Person> persons = new HashMap<>();

    private String personName;
    private Company company = null;
    private Car car = null;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    Person(String personName) {
        this.personName = personName;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();

        Person.persons.put(personName, this);
    }

    void setCompany(Company company) {
        this.company = company;
    }

    void setCar(Car car) {
        this.car = car;
    }

    void addParent(String name, String birthday) {
        this.parents.add(new Parent(name, birthday));
    }

    void addChild(String name, String birthday) {
        this.children.add(new Child(name, birthday));
    }

    void addPokemon(String name, String type) {
        this.pokemons.add(new Pokemon(name, type));
    }

    void printInfo() {
        System.out.print(String.format("%s%nCompany:%n", this.personName));
        System.out.print(this.company == null ? "" : this.company.toString());
        System.out.print("Car:\n");
        System.out.print(this.car == null ? "" : this.car.toString());
        System.out.print("Pokemon:\n");
        this.pokemons.forEach(e -> System.out.print(e.toString()));
        System.out.print("Parents:\n");
        this.parents.forEach(e -> System.out.print(e.toString()));
        System.out.print("Children:\n");
        this.children.forEach(e -> System.out.print(e.toString()));
    }
}

