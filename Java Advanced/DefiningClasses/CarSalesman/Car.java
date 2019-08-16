package DefiningClasses.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, String weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n%s%nWeight: %s%nColor: %s",
                this.model, this.engine.toString(),
                this.weight == null ? "n/a" : this.weight,
                this.color == null ? "n/a" : this.color);
    }
}
