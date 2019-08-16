package Q_Exams.RetakeExam15August2019.spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static double DECREASES_ASTRONAUTS_OXYGEN_VALUE = 5;
    private static double INITIAL_UNITS_OF_OXYGEN = 70;

    public Biologist(String name) {
        super(name, INITIAL_UNITS_OF_OXYGEN);
        super.setDecreasesAstronautsOxygenValue(DECREASES_ASTRONAUTS_OXYGEN_VALUE);
    }

}
