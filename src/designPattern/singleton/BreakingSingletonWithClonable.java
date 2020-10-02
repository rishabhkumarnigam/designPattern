package designPattern.singleton;

class Singleton implements Cloneable{

	private static final Singleton INSTANCE = new Singleton();

	private Singleton() {
	}

	public static Singleton getSingleton() {
		return INSTANCE;
	}
	
	@Override
	   protected Object clone()
	   throws CloneNotSupportedException {
	      return super.clone();
	   }
}




public class BreakingSingletonWithClonable {
	public static void main(String[] args) throws CloneNotSupportedException {
		Singleton singleton1 = Singleton.getSingleton();
		Singleton singleton2 = (Singleton) singleton1.clone();
	
		if(singleton1.hashCode()!=singleton2.hashCode()) {
			System.out.println("singleton broken with clonable");
		}
	}
}
