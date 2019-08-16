package panzer.models.parts;

import panzer.contracts.AttackModifyingPart;

import java.math.BigDecimal;

public class ArsenalPart extends AbstractPart implements AttackModifyingPart {

    private int attackModifier;

    public ArsenalPart(String model, double weight, BigDecimal price, int attackModifier) {
        super(model, weight, price);
        this.attackModifier = attackModifier;
    }

    @Override
    public int getAttackModifier() {
        return attackModifier;
    }

    @Override
    public String toString() {
        return String.format("%s Part - %s\n" +
                        "+%d %s",
                this.getClass().getSimpleName(), this.getModel(), this.getAttackModifier(), "Attack");
    }
}
