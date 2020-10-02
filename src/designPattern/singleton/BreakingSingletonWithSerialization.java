package designPattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BreakingSingletonWithSerialization {

	private static void serializeToFile(BasicSingleton singleton,String fileName) {
		try {
			FileOutputStream foo=new FileOutputStream(fileName);
			ObjectOutputStream oos=new ObjectOutputStream(foo);
			oos.writeObject(singleton);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static BasicSingleton deserializeFromFile(String fileName) {
		try {
			FileInputStream fis=new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(fis);
			return (BasicSingleton)ois.readObject();
		}
		catch(Exception e) {
			return null;	
		}
		
	}
	public static void main(String[] args) {
		
		BasicSingleton instanceOne=BasicSingleton.getBasicSingleton();
		serializeToFile(instanceOne, "MyFile.txt");
		BasicSingleton instanceTwo=deserializeFromFile("MyFile.txt");
		
		if(instanceOne.hashCode()==instanceTwo.hashCode()) {
			System.out.println("Singleton Not broken");
		}
		else {
			System.out.println("Singleton broken by Serialization");
		}
	
}
}
