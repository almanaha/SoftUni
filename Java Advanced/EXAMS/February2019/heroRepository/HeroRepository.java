package EXAMS.February2019.heroRepository;

import java.util.*;

public class HeroRepository {
    private List<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }

    public void add(Hero person) {
        this.data.add(person);
    }

    public void remove(String name) {
        this.data.removeIf(e -> e.getName().equals(name));
    }

    public int getCount() {
        return this.data.size();
    }

    public Hero getHeroWithHighestStrength() {
        return this.data.stream().max(Comparator.comparing(e -> e.getItem().getStrength()))
                .get();
    }

    public Hero getHeroWithHighestAgility() {
        return this.data.stream().max(Comparator.comparing(e -> e.getItem().getAgility()))
                .get();
    }

    public Hero getHeroWithHighestIntelligence() {
        return this.data.stream().max(Comparator.comparing(e -> e.getItem().getIntelligence()))
                .get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Hero hero : data) {
            sb.append(hero).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
