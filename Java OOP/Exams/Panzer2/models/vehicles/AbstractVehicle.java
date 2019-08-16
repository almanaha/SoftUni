package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractVehicle implements Vehicle {

    private String model;

    private double weight;

    private BigDecimal price;

    private int attack;

    private int defense;

    private int hitPoints;

    private Assembler assembler;

    protected AbstractVehicle(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.assembler = new VehicleAssembler1();
    }

    @Override
    public double getTotalWeight() {
        return this.weight + this.assembler.getTotalWeight();
    }

    @Override
    public BigDecimal getTotalPrice() {

        BigDecimal t = this.price;
        return t.add(assembler.getTotalPrice());
    }

    @Override
    public long getTotalAttack() {
        return this.attack + this.assembler.getTotalAttackModification();
    }

    @Override
    public long getTotalDefense() {
        return this.defense + this.assembler.getTotalDefenseModification();
    }

    @Override
    public long getTotalHitPoints() {
        return this.hitPoints + this.assembler.getTotalHitPointModification();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        return this.assembler.getParts();
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getPartsCount() {
        int count = 0;
        for (Part part : this.getParts()) {
            count++;
        }
        return count;
    }

    @Override
    public String toString() {
        /*
        {vehicleType} - {vehicleModel}
        Total Weight: {totalWeight}
        Total Price: {totalPrice}
        Attack: {totalAttack}
        Defense: {totalDefense}
        HitPoints: {totalHitPoints}
        Parts: {part1Model}, {part2Model}...
        */

        String partsStr = "None";
        int count = 0;
        for (Part part : this.getParts()) {
            count++;
        }
        if (count > 0) {
            List<String> tempParts = new ArrayList<>();
            final Iterable<Part> parts = this.getParts();
            for (Part part : this.getParts()) {
                tempParts.add(part.getModel());
            }
            partsStr = String.join(", ", tempParts);
        }

        return String.format("%s - %s\n" +
                "Total Weight: %.3f\n" +
                "Total Price: %.3f\n" +
                "Attack: %d\n" +
                "Defense: %d\n" +
                "HitPoints: %d\n" +
                "Parts: %s",
                this.getClass().getSimpleName(), this.getModel(), this.getTotalWeight(), this.getTotalPrice(), this.getTotalAttack(),
                this.getTotalDefense(), this.getTotalHitPoints(), partsStr);
    }
}