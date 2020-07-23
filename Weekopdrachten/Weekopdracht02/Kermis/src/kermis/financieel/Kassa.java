package kermis.financieel;

import java.util.ArrayList;

import kermis.base.Attractie;
import kermis.base.GokAttractie;

import kermis.util.*;

public class Kassa {
	private ArrayList<Attractie> attracties;
	private double alBelasteOmzet = 0.0f;
	private double totaleBelastingsKosten = 0;
	
	public Kassa(ArrayList<Attractie> attracties) {
		assert attracties != null;
		this.attracties = attracties;
	}
	
	public double berekenOmzet() {
		double omzet = 0.0f;
		for(Attractie a : attracties) {
			omzet += a.getOmzet();
		}
		return omzet;
	}
	
	public int totaalAantalVerkochteKaartjes() {
		int kaartjes = 0;
		for(Attractie a : attracties) {
			kaartjes += a.getVerkochteKaartjes();
		}
		return kaartjes;
	}
	
	public double belastingsInspectie() {
		final double belasting = BelastingsInspecteur.controleerAttractiesOpGokBelasting(this, alBelasteOmzet, attracties);
		totaleBelastingsKosten += belasting;
		alBelasteOmzet = berekenOmzet();
		return belasting;
	}
	
	public void printOverzicht() {
		System.out.println("F I N A N C I E E L   O V E R Z I C H T");
		System.out.println("_______________________________________");
		System.out.println("Totale omzet\t\t\t" + Util.euroToString( berekenOmzet() ));
		System.out.println("Al belast inkomen\t\t" + Util.euroToString( alBelasteOmzet ));
		
		for(Attractie a : attracties) {
			System.out.println("_______________________________________");
			System.out.println("Attractie overzicht:\t" + a.getNaam());
			System.out.println("Huidige omzet\t\t\t"+ Util.euroToString( a.getOmzet() ));
			System.out.println("Totale verkochte kaartjes\t" + a.getVerkochteKaartjes());
			
			if (a instanceof GokAttractie) {
				GokAttractie gok = (GokAttractie) a;
				System.out.println("Percentage gokbelasting\t\t" + (int)(100.0f*gok.kansSpelBelasting) + "%");
			}
		}
	}
}

