package panzer.models.vehicles;


import java.math.BigDecimal;

public class Vanguard extends BaseVehicle {

    public Vanguard(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model);
        super.setWeight(weight * 2);
        super.setPrice(price);
        super.setAttack((int) (attack * 0.75));
        super.setDefense((int) (defense * 1.5));
        super.setHitPoints((int) (hitPoints *1.75));
    }
}