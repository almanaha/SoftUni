package panzer.core;

import panzer.contracts.*;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShellPart;
import panzer.models.vehicles.Revenger;
import panzer.models.vehicles.Vanguard;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class BusinessManager implements Manager {

    private BattleOperator battleOperator;

    private Map<String, Vehicle> vehicles;

    private Map<String, Part> parts;

    private List<String> defeatedModels;

    public BusinessManager() {
        this.vehicles = new LinkedHashMap<>();
        this.parts = new HashMap<>();
        this.battleOperator = new PanzerBattleOperator();
        this.defeatedModels = new ArrayList<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        //type (string), model (string), weight (double), price (decimal), attack (integer), defense (integer), hitPoints (integer).
        String type = arguments.get(0);
        String model = arguments.get(1);
        double weight = Double.parseDouble(arguments.get(2));
        BigDecimal price = new BigDecimal(arguments.get(3));
        int attack = Integer.parseInt(arguments.get(4));
        int defense = Integer.parseInt(arguments.get(5));
        int hitPoints = Integer.parseInt(arguments.get(6));

        Vehicle vehicle = null;
        switch (type) {
            case "Vanguard":
                vehicle = new Vanguard(model, weight, price, attack, defense, hitPoints);
                break;
            case "Revenger":
                vehicle = new Revenger(model, weight, price, attack, defense, hitPoints);
                break;
        }
        this.vehicles.put(model, vehicle);

        return String.format("Created %s Vehicle - %s", type, model);
    }

    @Override
    public String addPart(List<String> arguments) {
        //vehicleModel (string), type (string), model (string), weight (double), price (decimal), additionalParameter (integer)
        String vehicleModel = arguments.get(0);
        String type = arguments.get(1);
        String model = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = new BigDecimal(arguments.get(4));
        int additionalParam = Integer.parseInt(arguments.get(5));

        Part part = null;
        switch (type) {
            case "Arsenal":
                part = new ArsenalPart(model, weight, price, additionalParam);
                break;
            case "Shell":
                part = new ShellPart(model, weight, price, additionalParam);
                break;
            case "Endurance":
                part = new EndurancePart(model, weight, price, additionalParam);
                break;
        }
        final Vehicle vehicle = this.vehicles.get(vehicleModel);
        this.vehicles.get(vehicleModel).addArsenalPart(part);
        final Vehicle vehicle1 = this.vehicles.get(vehicleModel);
        this.parts.put(model, part);

        return String.format("Added %s - %s to Vehicle - %s", type, model, vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        String model = arguments.get(0);
        if (this.vehicles.containsKey(model)) {
            return this.vehicles.get(model).toString();
        } else {
            return this.parts.get(model).toString();
        }
    }

    @Override
    public String battle(List<String> arguments) {
        String model1 = arguments.get(0);
        String model2 = arguments.get(1);

        Vehicle vehicle1 = this.vehicles.get(model1);
        Vehicle vehicle2 = this.vehicles.get(model2);
        String winnerModel = this.battleOperator.battle(vehicle1, vehicle2);

        String loserModel;
        if (winnerModel.equals(model1)) {
            loserModel = model2;
        } else {
            loserModel = model1;
        }
        this.defeatedModels.add(loserModel);
        this.vehicles.remove(loserModel);

        return String.format("%s versus %s -> %s Wins! Flawless Victory!",
                model1, model2, winnerModel);
    }

    @Override
    public String terminate(List<String> arguments) {
        List<String> remainingModels = this.vehicles.values().stream().map(Modelable::getModel).collect(Collectors.toList());

        String remainingModelsStr = String.join(", ", remainingModels);
        String defeatedModelsStr = String.join(", ", defeatedModels);
        if (remainingModels.isEmpty()) remainingModelsStr = "None";
        if (defeatedModels.isEmpty()) defeatedModelsStr = "None";
        int usedParts = this.vehicles.values().stream().mapToInt(Vehicle::getPartsCount).sum();

        return String.format("Remaining Vehicles: %s\n" +
                "Defeated Vehicles: %s\n" +
                "Currently Used Parts: %d",
                remainingModelsStr, defeatedModelsStr, usedParts);
    }
}
