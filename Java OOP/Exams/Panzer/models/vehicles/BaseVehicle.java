package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.BaseModel;
import panzer.models.miscellaneous.VehicleAssembler;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShellPart;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseVehicle extends BaseModel implements Vehicle {
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defense;
    private int hitPoints;
    private Assembler assembler;

    BaseVehicle(String model) {
        super(model);
        this.assembler = new VehicleAssembler();
    }

    @Override
    public double getTotalWeight() {
        return this.assembler.getTotalWeight() + this.weight;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.assembler.getTotalPrice().add(this.price);
    }

    @Override
    public long getTotalAttack() {
        return this.assembler.getTotalAttackModification()+this.attack;
    }

    @Override
    public long getTotalDefense() {
        return this.assembler.getTotalDefenseModification()+this.defense;
    }

    @Override
    public long getTotalHitPoints() {
        return this.assembler.getTotalHitPointModification()+this.hitPoints;
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
        Iterable<Part> partsModels = new LinkedList<>();

        Class assembler = VehicleAssembler.class;
        Field fieldArsenalParts = null;
        Field fieldShellParts = null;
        Field fieldEnduranceParts = null;
        try {
            fieldArsenalParts = assembler.getDeclaredField("arsenalParts");
            fieldArsenalParts.setAccessible(true);
            fieldShellParts = assembler.getDeclaredField("shellParts");
            fieldShellParts.setAccessible(true);
            fieldEnduranceParts = assembler.getDeclaredField("enduranceParts");
            fieldEnduranceParts.setAccessible(true);

            List<ArsenalPart> arsenalParts = (List<ArsenalPart>) fieldArsenalParts.get(this.assembler);
            List<ShellPart> shellParts = (List<ShellPart>) fieldShellParts.get(this.assembler);
            List<EndurancePart> enduranceParts = (List<EndurancePart>) fieldEnduranceParts.get(this.assembler);
          ((LinkedList<Part>) partsModels).addAll(arsenalParts);
          ((LinkedList<Part>) partsModels).addAll(shellParts);
          ((LinkedList<Part>) partsModels).addAll(enduranceParts);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return partsModels;


    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    protected void setPrice(BigDecimal price) {
        this.price = price;
    }

    protected void setAttack(int attack) {
        this.attack = attack;
    }

    protected void setDefense(int defense) {
        this.defense = defense;
    }

    protected void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }


    @Override
    public String toString() {
        List<Part> parts = (List<Part>) this.getParts();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(
                "%s - %s\n" +
                        "Total Weight: %.3f\n" +
                        "Total Price: %.3f\n" +
                        "Attack: %d\n" +
                        "Defense: %d\n" +
                        "HitPoints: %d\n",
                this.getClass().getSimpleName(),
                this.getModel(),
                this.getTotalWeight(),
                this.getTotalPrice(),
                this.getTotalAttack(),
                this.getTotalDefense(),
                this.getTotalHitPoints()));
        if(parts.isEmpty()){
            sb.append("Parts: None");
        }else {
            sb.append(String.format("Parts: %s",
                    parts.stream().map(Part::getModel).collect(Collectors.joining(", "))));
        }
        return sb.toString();
    }
}
