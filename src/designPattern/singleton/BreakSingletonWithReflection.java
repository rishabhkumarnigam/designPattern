package designPattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingletonWithReflection {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<BasicSingleton> privateConstructorForSingleton=
				BasicSingleton.class.getDeclaredConstructor();
		privateConstructorForSingleton.setAccessible(true);//changing the accessibility of private constructor to public
		
		BasicSingleton instanceFromReflection=privateConstructorForSingleton.newInstance();
		BasicSingleton anotherInstance=BasicSingleton.getBasicSingleton();
		
		if(instanceFromReflection.hashCode()==anotherInstance.hashCode()) {
			System.out.println("Singleton pattern not broken");
		}
		else {
			System.out.println("Singleton pattern broken with reflection");
		}
		
	}

}
