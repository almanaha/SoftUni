package Q_Exams.RetakeExam15August2019.spaceStation.models.astronauts;

import Q_Exams.RetakeExam15August2019.spaceStation.common.ExceptionMessages;
import Q_Exams.RetakeExam15August2019.spaceStation.models.bags.Backpack;
import Q_Exams.RetakeExam15August2019.spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut {
    private double DECREASES_ASTRONAUTS_OXYGEN_VALUE = 10;
    private String name;
    private double oxygen;
    private Bag bag;

    protected void setDecreasesAstronautsOxygenValue(double decreasesAstronautsOxygenValue) {
        this.DECREASES_ASTRONAUTS_OXYGEN_VALUE = decreasesAstronautsOxygenValue;
    }

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {

        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.getOxygen() >= DECREASES_ASTRONAUTS_OXYGEN_VALUE;
    }

    @Override
    public Bag getBag() {

        return this.bag;
    }

    @Override
    public void breath() {
        this.setOxygen(this.getOxygen() - DECREASES_ASTRONAUTS_OXYGEN_VALUE);
        if (this.getOxygen() < 0){
            this.setOxygen(0);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(String.format("Name: %s", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("Oxygen: %.0f", this.getOxygen()))
                .append(System.lineSeparator())
                .append(this.bag.toString());
        return stringBuilder.toString();
    }
}
