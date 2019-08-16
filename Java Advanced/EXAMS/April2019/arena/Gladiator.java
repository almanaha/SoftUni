package EXAMS.April2019.arena;

public class Gladiator {
    private String name;
    private Stat stat;
    private Weapon weapon;

    public Gladiator(String name, Stat stat, Weapon weapon) {
        this.name = name;
        this.stat = stat;
        this.weapon = weapon;
    }

    public String getName() {
        return this.name;
    }

    public int getStatPower() {
        return this.stat.getAgility() +
                this.stat.getFlexibility() +
                this.stat.getIntelligence() +
                this.stat.getSkills() +
                this.stat.getStrength();
    }

    public int getWeaponPower() {
        return this.weapon.getSharpness() +
                this.weapon.getSize() +
                this.weapon.getSolidity();
    }

    public int getTotalPower() {
        return this.getStatPower() + this.getWeaponPower();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d",
                this.getName(),
                this.getTotalPower()))
                .append(System.lineSeparator())
                .append("  Weapon Power: ")
                .append(this.getWeaponPower())
                .append(System.lineSeparator())
                .append("  Stat Power: ")
                .append(this.getStatPower());
        return sb.toString().trim();
    }
}
