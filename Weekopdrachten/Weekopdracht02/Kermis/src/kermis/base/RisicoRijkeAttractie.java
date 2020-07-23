package kermis.base;

public abstract class RisicoRijkeAttractie extends Attractie {
	private boolean isGekeurd = false;
	private int draaiLimiet = 0;
	private int aantalDraaingenAchterElkaar = 0;
	
	public RisicoRijkeAttractie(String naam, double prijs, Oppervlak oppervlak, int draaiLimiet) {
		super(naam, prijs, oppervlak);
		assert draaiLimiet > 0;
		
		type = "Risicovolle Attractie";
		
		this.draaiLimiet = draaiLimiet;
	}	
	
	@Override
	public boolean nieuweKlant() {
		if(isGekeurd && aantalDraaingenAchterElkaar < draaiLimiet) {
			super.nieuweKlant();
			aantalDraaingenAchterElkaar++;
			return true;			
		} else {
			return false;
		}
	}
	
	public void keurAttractie() {
		isGekeurd = true;
		aantalDraaingenAchterElkaar = 0;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("gekeurd: "+isGekeurd+"\ndraaiLimiet: "+draaiLimiet+"\naantal klanten voor onderhoud: "+(draaiLimiet-aantalDraaingenAchterElkaar));
	}
	
	@Override
	public void printStatus() {
		super.printStatus();
		System.out.println("Gekeurd\t\t\t"+ (isGekeurd ? "ja" : "nee"));
		System.out.println("Draaingen sinds keuring\t" + aantalDraaingenAchterElkaar);
	}
}
