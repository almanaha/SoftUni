package DefiningClasses.CarSalesman;

public class Engine {
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, String power, String displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, String power, String displacement, String efficiency) {
        this(model, power, displacement);
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s",
                this.model,
                this.power,
                this.displacement == null ? "n/a" : this.displacement,
                this.efficiency == null ? "n/a" : this.efficiency);
    }
}
