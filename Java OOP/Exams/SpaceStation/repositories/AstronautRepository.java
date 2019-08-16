package Q_Exams.RetakeExam15August2019.spaceStation.repositories;


import Q_Exams.RetakeExam15August2019.spaceStation.models.astronauts.Astronaut;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class AstronautRepository implements Repository<Astronaut> {
    private Map<String, Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashMap<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(this.astronauts.values());
    }

    @Override
    public void add(Astronaut model) {
        if (model == null){
            return;
        }
        this.astronauts.putIfAbsent(model.getName(), model);

    }

    @Override
    public boolean remove(Astronaut model) {
        if (model == null){
            return false;
        }
        Astronaut astronaut = this.astronauts.remove(model.getName());
        boolean isDeleted = true;
        if (astronaut == null){
            isDeleted = false;
        }
        return isDeleted;
    }

    @Override
    public Astronaut findByName(String name) {
        return this.astronauts.get(name);
    }
}
