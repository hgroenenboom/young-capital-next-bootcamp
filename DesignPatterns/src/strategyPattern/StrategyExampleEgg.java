package strategyPattern;

public class StrategyExampleEgg {
	public static void main(String[] args) {
		Ei ei = new Ei();
		ei.logEi();
		
		Bereiding bereiding = new Bereiding( new Koken(true) );
		bereiding.bereiden(ei).logEi();
		bereiding.bereiden(ei).logEi();
	}
}

class Eten {
	private int koolhydraten;
}

class Ei extends Eten {
	public static enum Type {
		VERS,
		ZACHTGEKOOKT,
		GEKOOKT,
		GEBAKKEN,
		ROERGEBAKKEN
	}
	
	private boolean isNogZacht = true;
	private boolean deDooierIsHeel = true;
	private boolean hetEiIsScrambled = false;
	private Type type = Type.VERS;
	
	Ei() {
		
	}
	
	void logEi() {
		System.out.println("Staat van EI: ");
		System.out.println("Het ei is " + (isNogZacht ? "zacht" : "hard") );
		System.out.println("De dooier is " + (deDooierIsHeel ? "heel" : "kapot"));
		System.out.println("En het ei is " + (hetEiIsScrambled ? "scrambled" : "heel"));
		System.out.println("Het ei is van type " + type);
		System.out.println();
	}
	
	public boolean isNogZacht() {
		return isNogZacht;
	}
	public void setNogZacht(boolean isNogZacht) {
		this.isNogZacht = isNogZacht;
	}
	public boolean isDeDooierIsHeel() {
		return deDooierIsHeel;
	}
	public void setDeDooierIsHeel(boolean deDooierIsHeel) {
		this.deDooierIsHeel = deDooierIsHeel;
	}
	public boolean isHetEiIsScrambled() {
		return hetEiIsScrambled;
	}
	public void setHetEiIsScrambled(boolean hetEiIsScrambled) {
		this.hetEiIsScrambled = hetEiIsScrambled;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
}



// Context
class Bereiding {
	private BereidWijze berijdwijze;
	
	public Bereiding(BereidWijze b) {
		berijdwijze = b;
		
	}
	
	public Ei bereiden(Ei ei) {
		System.out.println(berijdwijze.getBereidingsType());
		return berijdwijze.bereiden(ei);
	}
}

// Strategy
interface BereidWijze {
	Ei bereiden(Ei ei);
	String getBereidingsType();
}

class Koken implements BereidWijze {
	private boolean zachtGekookt;
	
	Koken(boolean zachtGekookt) {
		this.zachtGekookt = zachtGekookt;
	}
	
	@Override
	public Ei bereiden(Ei ei) {
		assert (ei.getType() == Ei.Type.VERS || ei.getType() == Ei.Type.ZACHTGEKOOKT);
		
		ei.setDeDooierIsHeel(true);
		if(zachtGekookt) {
			ei.setType( Ei.Type.values()[ ei.getType().ordinal() + 1 ] );
		} else {
			ei.setType(Ei.Type.ZACHTGEKOOKT);
		}
		return ei;
	}
	
	@Override
	public String getBereidingsType() {
		return "Koken";
	}
}

class Bakken implements BereidWijze {
	public Bakken() {
		// TODO Auto-generated constructor stub
	}	
	
	@Override
	public Ei bereiden(Ei ei) {
		return ei;
	}
	
	@Override
	public String getBereidingsType() {
		// TODO Auto-generated method stub
		return null;
	}
}

class Roerbakken implements BereidWijze {
	public Roerbakken() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Ei bereiden(Ei ei) {
		return ei;
	}
	
	@Override
	public String getBereidingsType() {
		// TODO Auto-generated method stub
		return null;
	}
}