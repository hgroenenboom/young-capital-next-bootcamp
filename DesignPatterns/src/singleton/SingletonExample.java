package singleton;

public class SingletonExample {
	public static void main(String[] args) {
		
	}
}

class Singleton {
	private int numberToGive = 0;
	
	private Singleton s = null;
	private Singleton() {
	}
	
	Singleton getInstanceOf() {
		if(s == null) {
			s = new Singleton();
		}
		
		return s;
	}
	
	// Always gives the next integer since the last call, no matter where in the code
	int getNextNumber() {
		return numberToGive++;
	}
}

class User {
	punlic int requestUniqueNumber() {
		
	}
}
