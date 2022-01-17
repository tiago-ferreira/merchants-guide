package com.merchants.guide.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.merchants.guide.decorator.IntergalaticAmount;
import com.merchants.guide.utils.StringUtility;

public class CurrencyTypeFactory {
	
	StringUtility utility = new StringUtility();

	public IntergalaticAmount createInstace(IntergalaticAmount amount, String type, double factor) {
		if (factor > 0)
			return createCurrencyInstance(type, amount, factor);
		if(factor <= 0)
			return createCurrencyInstance(type, amount);
		return null;
	}
	
	public IntergalaticAmount createCurrencyInstance(String clazz, Object... args) {
		Object instance = null;
		try {
			String clazzName = utility.capitalizeFirstLetter(clazz);
			Class<?> myClass = Class.forName("com.merchants.guide.decorator."+clazzName);
			@SuppressWarnings("rawtypes")
			Class[] paramClass = getClassOfTheObjects(args);
			Constructor<?> constructor = myClass.getConstructor(paramClass);
			instance = constructor.newInstance(args);
		} catch (ClassNotFoundException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
			System.err.println("I have no idea what you are talking about");
		}
		return (IntergalaticAmount) instance;
	}
	
	@SuppressWarnings("rawtypes")
	private Class[] getClassOfTheObjects(Object... objs){
		Class[] classToReturn = new Class[objs.length];
		for (int i=0; i<objs.length; i++) {
			if(objs[i] instanceof IntergalaticAmount)
				classToReturn[i] = IntergalaticAmount.class;
			if(objs[i] instanceof Double)
				classToReturn[i] = Double.TYPE;
		}
		return classToReturn;
	}

}
