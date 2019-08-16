package Q_Exams.RetakeExam15August2019.spaceStation.models.astronauts;

import Q_Exams.RetakeExam15August2019.spaceStation.models.bags.Bag;

public interface Astronaut {
    String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
