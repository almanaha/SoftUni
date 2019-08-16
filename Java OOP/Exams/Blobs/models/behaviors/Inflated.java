package models.behaviors;

import models.Blob;

public class Inflated extends AbstractBehavior {
    private static final int INFLATED_HEALTH_INCREMENT = 50;
    private static final int INFLATED_HEALTH_DECREMENT = 10;

    @Override
    public void trigger(Blob source) {
        if (!super.isTriggered()) {
            super.setIsTriggered(true);
            source.setHealth(source.getHealth() + INFLATED_HEALTH_INCREMENT);
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect()) {
            super.setToDelayRecurrentEffect(false);
        } else {
            source.setHealth(source.getHealth() - INFLATED_HEALTH_DECREMENT);
        }
    }
}
