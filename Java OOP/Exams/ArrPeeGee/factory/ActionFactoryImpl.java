package app.factory;

import app.contracts.Action;
import app.contracts.ActionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class ActionFactoryImpl implements ActionFactory {
    private final static String ACTION_PATH_NAME = "app.models.actions.";
    @SuppressWarnings("unchecked")
    @Override
    public Action create(String actionName, String... participantNames) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Action action;
        Class classAction= Class.forName(ACTION_PATH_NAME + actionName);
        Constructor declaredConstructor = classAction.getDeclaredConstructor();
        action = (Action) declaredConstructor.newInstance();
        return action;
    }
}
