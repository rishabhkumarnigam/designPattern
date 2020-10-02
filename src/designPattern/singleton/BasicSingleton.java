package designPattern.singleton;

public class BasicSingleton {

	private static final BasicSingleton INSTANCE = new BasicSingleton();

	private BasicSingleton() {
	}

	public static BasicSingleton getBasicSingleton() {
		return INSTANCE;
	}
}

class Client{
	public static void main(String[] args) {
		BasicSingleton singleton1 = BasicSingleton.getBasicSingleton();
		BasicSingleton singleton2 = BasicSingleton.getBasicSingleton();
		if(singleton1.hashCode()==singleton2.hashCode()) {
			System.out.println("only one object");
		}
	}
}
