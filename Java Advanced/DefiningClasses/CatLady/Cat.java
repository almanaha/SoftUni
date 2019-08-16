package DefiningClasses.CatLady;

abstract class Cat {
    private String name;

    Cat(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}
