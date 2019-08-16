package panzer.models.vehicles;

import java.math.BigDecimal;

public class Revenger extends AbstractVehicle {

    public Revenger(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight, price.multiply(BigDecimal.valueOf(1.5)), (int) (attack + attack * 1.5), (int) (defense - defense * 0.5), (int) (hitPoints - hitPoints * 0.5));
    }
}
