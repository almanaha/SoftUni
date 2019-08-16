package DefiningClasses.CatLady;

public class Siamese extends Cat {
    private double earSize;

    Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.getClass().getSimpleName(), super.getName(), this.earSize);
    }
}