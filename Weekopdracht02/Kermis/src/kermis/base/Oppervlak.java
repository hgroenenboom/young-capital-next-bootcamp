package kermis.base;

public class Oppervlak {
	private float w, h;
	
	public Oppervlak() {
		w = 0.0f;
		h = 0.0f;
	}
	public Oppervlak(float width, float height) {
		assert width > 0.0f;
		assert height > 0.0f;
		
		w = width;
		h = height;
	}
	
	// SETTERS - GETTERS
	public final String toString() {
		return String.valueOf(w) + " bij " + String.valueOf(h);
	}
}
