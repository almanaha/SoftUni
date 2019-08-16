package Q_Exams.RetakeExam15August2019.spaceStation.core;

import Q_Exams.RetakeExam15August2019.spaceStation.common.ConstantMessages;
import Q_Exams.RetakeExam15August2019.spaceStation.common.ExceptionMessages;
import Q_Exams.RetakeExam15August2019.spaceStation.models.astronauts.Astronaut;
import Q_Exams.RetakeExam15August2019.spaceStation.models.astronauts.Biologist;
import Q_Exams.RetakeExam15August2019.spaceStation.models.astronauts.Geodesist;
import Q_Exams.RetakeExam15August2019.spaceStation.models.astronauts.Meteorologist;
import Q_Exams.RetakeExam15August2019.spaceStation.models.mission.Mission;
import Q_Exams.RetakeExam15August2019.spaceStation.models.mission.MissionImpl;
import Q_Exams.RetakeExam15August2019.spaceStation.models.planets.Planet;
import Q_Exams.RetakeExam15August2019.spaceStation.models.planets.PlanetImpl;
import Q_Exams.RetakeExam15August2019.spaceStation.repositories.AstronautRepository;
import Q_Exams.RetakeExam15August2019.spaceStation.repositories.PlanetRepository;
import Q_Exams.RetakeExam15August2019.spaceStation.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private Mission mission;
    private int exploredPlanets = 0;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;
        if (Biologist.class.getSimpleName().equals(type)){
            astronaut = new Biologist(astronautName);
        } else if (Geodesist.class.getSimpleName().equals(type)){
            astronaut = new Geodesist(astronautName);
        } else if (Meteorologist.class.getSimpleName().equals(type)){
            astronaut = new Meteorologist(astronautName);
        }
        if (astronaut == null){
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(astronaut);
        String result = String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
        return result;
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        Collection<String> planetItems = planet.getItems();
        Collections.addAll(planetItems, items);
        planetRepository.add(planet);
        String result = String.format(ConstantMessages.PLANET_ADDED,planetName);
        return result;
    }

    @Override
    public String retireAstronaut(String astronautName) {

        Astronaut astronaut = astronautRepository.findByName(astronautName);
        if (astronaut == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST,astronautName));
        }
        astronautRepository.remove(astronaut);

        String result = String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
        return result;
    }

    @Override
    public String explorePlanet(String planetName) {
        Collection<Astronaut> astronauts = astronautRepository
                .getModels()
                .stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toCollection(ArrayList::new));

        if (astronauts.size() == 0){
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Planet planet = planetRepository.findByName(planetName);

        this.mission.explore(planet, astronauts);
        this.exploredPlanets++;

        long dead = astronauts.stream().filter(a -> a.getOxygen() == 0).count();
        String result = String.format(ConstantMessages.PLANET_EXPLORED, planetName, dead);
        return result;
    }

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, this.exploredPlanets))
                .append(System.lineSeparator())
                .append("Astronauts info:");
        for (Astronaut astr: astronautRepository.getModels()) {
            stringBuilder
                    .append(System.lineSeparator())
                    .append(astr.toString());
        }
        return stringBuilder.toString();
    }
}
