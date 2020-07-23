package singleton;

public class SingletonExample {
	public static void main(String[] args) {
		User a = new User();
		User b = new User();
		
		System.out.println(a.requestUniqueNumber());
		System.out.println(b.requestUniqueNumber());
		System.out.println(a.requestUniqueNumber());
		System.out.println(a.requestUniqueNumber());
		System.out.println(b.requestUniqueNumber());
	}
}

class Singleton {
	private static int numberToGive = 0;
	
	private static Singleton s = null;
	private Singleton() {
	}
	
	public static Singleton getInstanceOf() {
		if(s == null) {
			s = new Singleton();
		}
		
		return s;
	}
	
	// Always gives the next integer since the last call, no matter where in the code
	public int getNextNumber() {
		return numberToGive++;
	}
}

class User {
	public int requestUniqueNumber() {
		return Singleton.getInstanceOf().getNextNumber();
	}
}
