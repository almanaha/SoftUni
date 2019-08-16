package panzer.models.parts;

import panzer.contracts.DefenseModifyingPart;

import java.math.BigDecimal;

public class ShellPart extends AbstractPart implements DefenseModifyingPart {

    private int defenseModifier;

    public ShellPart(String model, double weight, BigDecimal price, int defenseModifier) {
        super(model, weight, price);
        this.defenseModifier = defenseModifier;
    }

    @Override
    public int getDefenseModifier() {
        return defenseModifier;
    }

    @Override
    public String toString() {
        return String.format("%s Part - %s\n" +
                        "+%d %s",
                this.getClass().getSimpleName(), this.getModel(), this.getDefenseModifier(), "Defense");
    }
}
