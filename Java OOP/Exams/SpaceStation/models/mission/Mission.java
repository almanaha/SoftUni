package Q_Exams.RetakeExam15August2019.spaceStation.models.mission;

import Q_Exams.RetakeExam15August2019.spaceStation.models.astronauts.Astronaut;
import Q_Exams.RetakeExam15August2019.spaceStation.models.planets.Planet;

import java.util.Collection;

public interface Mission {
    void explore(Planet planet, Collection<Astronaut> astronauts);
}
