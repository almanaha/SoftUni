package IteratorsAndComparators.Exercises.ComparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private Integer age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        return this.name.equals(((Person)obj).name) && this.age == ((Person)obj).age;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.age.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s %d",this.name,this.age);
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name) == 0 ?
                this.age - o.age :
                this.name.compareTo(o.name);
    }
}
