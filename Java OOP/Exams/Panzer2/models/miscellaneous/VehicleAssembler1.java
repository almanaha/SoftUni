package panzer.models.miscellaneous;

import panzer.contracts.*;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShellPart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VehicleAssembler1 implements Assembler {

    private List<Part> parts;

    public VehicleAssembler1() {
        this.parts = new ArrayList<>();
    }

    @Override
    public double getTotalWeight() {
        return this.parts.stream().mapToDouble(Part::getWeight).sum();
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal result = BigDecimal.ZERO;

        for (Part part : this.parts) {
            result = result.add(part.getPrice());
        }

        return result;
    }

    @Override
    public long getTotalAttackModification() {
        ArsenalPart[] arsenalParts = this.parts.stream().filter(x -> x instanceof ArsenalPart).toArray(ArsenalPart[]::new);
        return Arrays.stream(arsenalParts).mapToInt(ArsenalPart::getAttackModifier).sum();
    }

    @Override
    public long getTotalDefenseModification() {
        ShellPart[] shellParts = this.parts.stream().filter(x -> x instanceof ShellPart).toArray(ShellPart[]::new);
        return Arrays.stream(shellParts).mapToInt(ShellPart::getDefenseModifier).sum();
    }

    @Override
    public long getTotalHitPointModification() {
        EndurancePart[] enduranceParts = this.parts.stream().filter(x -> x instanceof EndurancePart).toArray(EndurancePart[]::new);
        return Arrays.stream(enduranceParts).mapToInt(EndurancePart::getHitPointsModifier).sum();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.parts.add(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.parts.add(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.parts.add(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        return this.parts;
    }
}