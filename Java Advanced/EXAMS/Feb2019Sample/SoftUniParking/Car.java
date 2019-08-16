package EXAMS.Feb2019Sample.SoftUniParking;

public class Car {
    private String make;
    private String model;
    private int horsePower;
    private String registrationNumber;

    public Car(String make, String model, int horsePower, String registrationNumber) {
        this.setMake(make);
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setRegistrationNumber(registrationNumber);
    }

    public String getMake() {
        return make;
    }

    private void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    private void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return String.format("Make: %s%nModel: %s%nHorsePower: %d%nRegistrationNumber: %s%n",
                this.getMake(),
                this.getModel(),
                this.getHorsePower(),
                this.getRegistrationNumber());
    }
}
