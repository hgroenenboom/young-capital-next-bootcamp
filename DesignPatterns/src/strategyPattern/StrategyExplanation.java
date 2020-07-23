package strategyPattern;


class Demo {
	public static void main(String[] args) {
		Box box = new Box();
		box.setDistance(0.0f);
		box.setWeight(2.4f);
		box.setWidth(2.0f);
		
		CarTransportMethod.setKostenPerKm(0.3, 0.11);
		
		StrategyTransportContext transport = new StrategyTransportContext(new CarTransportMethod());
		System.out.println(transport.transport(box));
		transport = new StrategyTransportContext(new PlaneTransportMethod());
	}
}




class Box {
	private float distance = 0.0f;
	private float weight;
	private float width;
	
	Box() {}

	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
}



// Calls methods of interface
class StrategyTransportContext {
	private StrategyTransportMethod m;
	
	public StrategyTransportContext(StrategyTransportMethod m) {
		this.m = m;
	}
	public void setStrategyTransportMethod(StrategyTransportMethod m) {
		this.m = m;
	}
	
	public String transport(Box b) {
		return m.transportDescription(b);
	}
}

// Specificies interface methods
interface StrategyTransportMethod {
	double transportCosts(Box b);
	String transportDescription(Box b);
}

// Implementation of interface to be called by context.
class CarTransportMethod implements StrategyTransportMethod {
	private static double kostenPerKm = 0.0f;
	
	public double transportCosts(Box b) {
		return b.getWeight() * kostenPerKm;
	}
	public String transportDescription(Box b) {
		return "Transport per car kosts " + kostenPerKm + " per km";
	}
	
	
	public static double getKostenPerKm() {
		return kostenPerKm;
	}
	public static void setKostenPerKm(double benzinePerKm, double wegBelastingPerKm) {
		CarTransportMethod.kostenPerKm = benzinePerKm + wegBelastingPerKm;
	}
}

//Implementation of interface to be called by context.
class PlaneTransportMethod implements StrategyTransportMethod {
	public double transportCosts(Box b) {
		return 0;
	}
	public String transportDescription(Box b) {
		return "";
	}
}

