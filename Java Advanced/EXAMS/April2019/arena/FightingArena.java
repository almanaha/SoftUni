package EXAMS.April2019.arena;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FightingArena {
    private List<Gladiator> gladiators;
    private String name;

    public FightingArena(String name) {
        this.name = name;
        this.gladiators = new ArrayList<>();
    }

    public void add(Gladiator gladiator) {
        this.gladiators.add(gladiator);
    }

    public void remove(String name) {
        this.gladiators.removeIf(e -> e.getName().equals(name));
    }

    public Gladiator getGladiatorWithHighestStatPower() {
        return this.gladiators.stream()
                .max(Comparator.comparing(Gladiator::getStatPower))
                .get();
    }

    public Gladiator getGladiatorWithHighestWeaponPower() {
        return this.gladiators.stream()
                .max(Comparator.comparing(Gladiator::getWeaponPower))
                .get();
    }

    public Gladiator getGladiatorWithHighestTotalPower() {
        return this.gladiators.stream()
                .max(Comparator.comparing(Gladiator::getTotalPower))
                .get();
    }

    public int getCount(){
        return this.gladiators.size();
    }

    @Override
    public String toString() {
        return String.format("%s - %s gladiators are participating.\n",
                this.name,
                this.getCount());
    }
}
