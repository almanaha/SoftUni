package panzer.core;

import panzer.constants.Config;
import panzer.contracts.BattleOperator;
import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShellPart;
import panzer.models.vehicles.Revenger;
import panzer.models.vehicles.Vanguard;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {
    private Map<String, Vehicle> vehicles;
    private List<Part> parts;
    private List<Vehicle> defeatedVehicles;
    private BattleOperator battleOperator;

    public ManagerImpl() {
        this.vehicles = new LinkedHashMap<>();
        this.parts = new LinkedList<>();
        this.defeatedVehicles = new LinkedList<>();
        this.battleOperator = new PanzerBattleOperator();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        // {vehicleType} {model} {weight} {price} {attack} {defense} {hitPoints}
        String vehicleType = arguments.get(1);
        String model = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = BigDecimal.valueOf(Long.parseLong(arguments.get(4)));
        int attack = Integer.parseInt(arguments.get(5));
        int defense = Integer.parseInt(arguments.get(6));
        int hitPoints = Integer.parseInt(arguments.get(7));
        Vehicle vehicle = null;

        if (vehicleType.equals(Config.VEHICLE_VANGUARD)) {
            vehicle = new Vanguard(model, weight, price, attack, defense, hitPoints);

        } else if (vehicleType.equals(Config.VEHICLE_REVENGER)) {
            vehicle = new Revenger(model, weight, price, attack, defense, hitPoints);
        }
        this.vehicles.putIfAbsent(model, vehicle);
        return String.format("Created %s Vehicle - %s", vehicleType, model);
    }

    @Override
    public String addPart(List<String> arguments) {
        // Part {vehicleModel} {partType} {model} {weight} {price} {additionalParameter}
        Part part = null;

        String vehicleModel = arguments.get(1);
        String partType = arguments.get(2);
        String model = arguments.get(3);
        double weight = Double.parseDouble(arguments.get(4));
        BigDecimal price = BigDecimal.valueOf(Long.parseLong(arguments.get(5)));
        int additionalParameter = Integer.parseInt(arguments.get(6));
        Vehicle vehicle = this.vehicles.get(vehicleModel);

        if (partType.equals(Config.PART_ARSENAL)) {
            part = new ArsenalPart(model, weight, price, additionalParameter);
            vehicle.addArsenalPart(part);
        } else if (partType.equals(Config.PART_SHELL)) {
            part = new ShellPart(model, weight, price, additionalParameter);
            vehicle.addShellPart(part);
        } else if (partType.equals(Config.PART_ENDURANCE)) {
            part = new EndurancePart(model, weight, price, additionalParameter);
            vehicle.addEndurancePart(part);
        }
this.parts.add(part);
        return String.format("Added %s - %s to Vehicle - %s", partType, model, vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        if (this.vehicles.containsKey(arguments.get(1))) {
            return this.vehicles.get(arguments.get(1)).toString();
        } else if (this.parts.stream().anyMatch(x->x.getModel().equals(arguments.get(1)))) {
            return this.parts.stream().filter(x->x.getModel().
                    equals(arguments.get(1))).limit(1).collect(Collectors.toList()).get(0).toString();
        } else {
            return null;
        }
    }

    @Override
    public String battle(List<String> arguments) {
        Vehicle attacker = this.vehicles.get(arguments.get(1));
        Vehicle target = this.vehicles.get(arguments.get(2));
        String winner = this.battleOperator.battle(attacker, target);
        if (winner.equals(attacker.getModel())) {
            this.vehicles.remove(target.getModel());
            this.defeatedVehicles.add(target);
        } else {
            this.vehicles.remove(attacker.getModel());
            this.defeatedVehicles.add(attacker);
        }
        return String.format("%s versus %s -> %s Wins! Flawless Victory!",
                attacker.getModel(),
                target.getModel(),
                winner);
    }

    @Override
    public String terminate(List<String> arguments)
    {
        String remainingVehicles = "None";
        String defeatedVehicles = "None";
        int countUsedParts = 0;

        for (Vehicle vehicle: this.vehicles.values()) {
            for (Part part: vehicle.getParts()) {
                countUsedParts++;
            }
        }
        if(!this.vehicles.isEmpty()){
            remainingVehicles = String.join(", ", this.vehicles.keySet());
        }
        if(!this.defeatedVehicles.isEmpty()){
            defeatedVehicles = this.defeatedVehicles.stream()
                    .map(Vehicle::getModel).collect(Collectors.joining(", "));
        }
        return String.format(
                "Remaining Vehicles: %s\n" +
                "Defeated Vehicles: %s\n" +
                "Currently Used Parts: %d\n",
                remainingVehicles,
                defeatedVehicles,
                countUsedParts
                );
    }
}
