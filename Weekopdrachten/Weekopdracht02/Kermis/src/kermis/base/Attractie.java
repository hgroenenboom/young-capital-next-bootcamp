package kermis.base;

public class Attractie {
	// parameters
	private String naam;
	private double prijs;
	private Oppervlak oppervlak; 
	protected String type = "Attractie";
	
	// variables
	protected float omzet = 0.0f;
	private int aantalGekochteKaartjes = 0;

	public Attractie(String naam, double prijs, Oppervlak oppervlak) {
		assert naam != null;
		assert prijs > 0.0f;
		assert oppervlak != null;
		
		this.naam = naam;
		this.prijs = prijs;
		this.oppervlak = oppervlak;
	}
	
	public boolean nieuweKlant() {
		omzet += prijs;
		aantalGekochteKaartjes++;
		return true;
	}
	
	// getters
	public double getOmzet() { 					return omzet; }
	public final int getVerkochteKaartjes() { 	return aantalGekochteKaartjes; }
	public final String getNaam()	{ 			return naam; }
	
	// logging
	public void printInfo() {
		System.out.println("\nAttractie\nNaam: " + naam + "\nPrijs: " + prijs + "\nOppervlak: " + oppervlak.toString());
		System.out.println("Omzet: " + getOmzet() + "\nAantal verkochte kaartjes: " + getVerkochteKaartjes());
	}
	
	public void printStatus() {
		System.out.println("_______________________________________");
		System.out.println("Attractie status:\t" + naam);
		System.out.println("Kaartjes verkocht\t" + aantalGekochteKaartjes);
		System.out.println("Overvlak\t\t" + oppervlak.toString());
		System.out.println("Type\t\t\t" + type);
	}
}
