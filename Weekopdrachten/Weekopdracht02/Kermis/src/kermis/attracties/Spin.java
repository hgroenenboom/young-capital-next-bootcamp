package kermis.attracties;

import kermis.base.Oppervlak;
import kermis.base.RisicoRijkeAttractie;

public class Spin extends RisicoRijkeAttractie {
	public Spin() {
		super("Spin", 2.25, new Oppervlak(), 5 );
	}
}