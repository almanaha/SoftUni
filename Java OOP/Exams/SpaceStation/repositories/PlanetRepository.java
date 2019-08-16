package Q_Exams.RetakeExam15August2019.spaceStation.repositories;

import Q_Exams.RetakeExam15August2019.spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlanetRepository implements Repository<Planet> {
    private Map<String, Planet> planets;

    public PlanetRepository() {
        this.planets = new LinkedHashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planets.values());
    }

    @Override
    public void add(Planet model) {
        if (model == null){
            return;
        }
        this.planets.putIfAbsent(model.getName(), model);

    }

    @Override
    public boolean remove(Planet model) {
        if (model == null){
            return false;
        }
        Planet planet = this.planets.remove(model.getName());
        boolean isDeleted = true;
        if (planet == null){
            isDeleted = false;
        }
        return isDeleted;
    }

    @Override
    public Planet findByName(String name) {
        return this.planets.get(name);
    }
}
