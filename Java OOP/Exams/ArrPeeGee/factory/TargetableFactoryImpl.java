package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TargetableFactoryImpl implements TargetableFactory {
    private final static String HERO_PATH_NAME = "app.models.participants.";

    @SuppressWarnings("unchecked")
    @Override
    public Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Targetable targetable;
        Class classTargetable = Class.forName(HERO_PATH_NAME + className);
        Constructor declaredConstructor = classTargetable.getDeclaredConstructor(String.class);
        targetable = (Targetable) declaredConstructor.newInstance(name);
        return targetable;
    }
}
