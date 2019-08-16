package barracksExtended.core.factories;

import barracksExtended.contracts.Unit;
import barracksExtended.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {


	private static final String UNITS_PACKAGE_NAME =
			"barracksExtended.models.units.";

	@Override
	public Unit createUnit(String unitType)  {
		String clazzName = UNITS_PACKAGE_NAME + unitType;
		try {
			Class unit = Class.forName(clazzName);
			Constructor constructor = unit.getDeclaredConstructors()[0];
			constructor.setAccessible(true);
			Object trainUnit = constructor.newInstance();
			return (Unit)trainUnit;

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException ignore) {
		}
		throw new IllegalArgumentException("Wrong unit type: " + unitType);
	}
}
