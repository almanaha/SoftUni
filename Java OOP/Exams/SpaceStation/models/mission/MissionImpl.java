package Q_Exams.RetakeExam15August2019.spaceStation.models.mission;

import Q_Exams.RetakeExam15August2019.spaceStation.models.astronauts.Astronaut;
import Q_Exams.RetakeExam15August2019.spaceStation.models.bags.Bag;
import Q_Exams.RetakeExam15August2019.spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Iterator;

public class MissionImpl implements Mission {

    public MissionImpl() { }

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        Iterator<String> iterator = planet.getItems().iterator();

        for (Astronaut current: astronauts) {

            Collection<String> bagItems = current.getBag().getItems();

            while (current.canBreath() && iterator.hasNext()){
                String item = iterator.next();
                bagItems.add(item);
                iterator.remove();
                current.breath();
            }
        }
    }
}
