package kermis.base;

public abstract class GokAttractie extends Attractie {
	public final static double kansSpelBelasting = 0.3f; 		// SHOULD BE IN SETTINGS STATIC CLASS (oid)
	private double belasteOmzet = 0.0;
	
	public GokAttractie(String naam, double prijs, Oppervlak oppervlak) {
		super(naam, prijs, oppervlak);
		
		type = "Gokattractie";
	}
	
	// Make sure to use this function to apply the kansSpelBelasting op de omzet/inkomsten of the implementation
	public double trekGokBelastingAf() {
		final double omzetOmBelastingOverTeBetalen = omzet - belasteOmzet;
		final double belasting = omzetOmBelastingOverTeBetalen * kansSpelBelasting;
		
		omzet -= belasting;
		belasteOmzet = omzet; // onthoudt de al belaste omzet. 
		
		return belasting;
	}
}
