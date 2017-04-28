package modell;

/**Diese Klasse wird zum Erstellen eines Objektes Rechteck benötigt. </br>
 * Folgende Methoden werden benutzt: 
 * {@link #berechneFlaeche()}</br>
 * {@link #berechneUmfang()} </br>
 * {@link #check()}</br> 
 * {@link #getLaenge()}</br>
 * {@link #getBreite()}</br>
 * {@link #setLaenge(double)}</br>
 * {@link #setBreite(double)}</br>
 * {@link #Rechteck(double, double)}</br>
 * 
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 *
 */
public class Rechteck implements Figur {
	private double laenge;
	private double breite;

	/**
	 * Diese Methode wird benötigt um im späteren Verlauf benötigt, </br>
	 * um ein Rechteck zu erzeugen.
	 * @param laenge
	 * @param breite
	 */
	
	public Rechteck(double laenge, double breite) {
		check(laenge);
		check(breite);
		this.laenge = laenge;
		this.breite = breite;
	}
	
	/**
	 * Mit dieser Methode kann man die Länge abrufen.
	 * @return	breite
	 */
	
	public double getLaenge() {
		return laenge;
	}
	
	/**
	 * Mit dieser Methode wird die Länge festgelegt.
	 * @param laenge
	 */
	
	public void setLaenge(double laenge) {
		check(laenge);
		this.laenge = laenge;
	}
	
	/**
	 * Mit dieser Methode kann man die Breite abrufen.
	 * @return	breite
	 */
	public double getBreite() {
		return breite;
	}
	/**
	 * Mit dieser Methode wird die Breite festgelegt.
	 * @param breite
	 */
	public void setBreite(double breite) {
		check(breite);
		this.breite = breite;
	}
	/**
	 * Mit dieser Methode wird der Flächeninhalt des Rechtecks berechnet.
	 */
	@Override
	public double berechneFlaeche() {
		check(laenge);
		check(breite);
		double i = laenge * breite;
		return i;
	}

	/**
	 * Mit dieser Methode werden die eingegebenen Daten überpfüft.
	 */
	@Override
	public void check(double value) {
		if (value <= 0.0) {
			throw new IllegalArgumentException("Die eingegebenen Werte dürfen nicht negativ sein.");
		}
	}

	@Override
	public double berechneUmfang() {
		double i = (laenge + breite) * 2;
		return i;
	}

}
