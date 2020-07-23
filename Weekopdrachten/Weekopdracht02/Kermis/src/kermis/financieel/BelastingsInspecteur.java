package kermis.financieel;

import java.util.ArrayList;

import kermis.base.Attractie;
import kermis.base.GokAttractie;

import kermis.util.*;

class BelastingsInspecteur {
	static double controleerAttractiesOpGokBelasting(Kassa kassa, double alBellasteOmzet, ArrayList<Attractie> attracties) {
		final double oudeOmzet = kassa.berekenOmzet();
		
		double gokbelasting = 0.0f;
		for(Attractie a : attracties) {
			if(a instanceof GokAttractie) {
				gokbelasting  += ((GokAttractie) a).trekGokBelastingAf();
			} 
		}
		
		final double nieuweOmzet = kassa.berekenOmzet();
		
		System.out.println("B E L A S T I N G   O V E R Z I C H T");
		System.out.println("Huidige omzet\t\t "+ Util.euroToString(oudeOmzet));
		System.out.println("Eerde belaste omzet\t- " + Util.euroToString(alBellasteOmzet));
		System.out.println("\t\t\t_________");
		System.out.println("Te belasten\t\t "+ Util.euroToString(oudeOmzet - alBellasteOmzet));
		System.out.println("Gokbelasting\t\t- " + Util.euroToString(gokbelasting));
		System.out.println("\t\t\t_________");
		System.out.println("Nieuwe omzet\t\t  " + Util.euroToString(nieuweOmzet));
		
		alBellasteOmzet = nieuweOmzet;
		return gokbelasting;
	}
}

