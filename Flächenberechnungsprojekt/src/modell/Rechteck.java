package modell;

/**Diese Klasse wird zum Erstellen eines Objektes Rechteck ben�tigt. </br>
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
 * @author Mauricio K�ll & Johannes Lindner
 * @version 1.0
 *
 */
public class Rechteck implements Figur {
	private double laenge;
	private double breite;

	/**
	 * Diese Methode wird ben�tigt um im sp�teren Verlauf ben�tigt, </br>
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
	 * Mit dieser Methode kann man die L�nge abrufen.
	 * @return	breite
	 */
	
	public double getLaenge() {
		return laenge;
	}
	
	/**
	 * Mit dieser Methode wird die L�nge festgelegt.
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
	 * Mit dieser Methode wird der Fl�cheninhalt des Rechtecks berechnet.
	 */
	@Override
	public double berechneFlaeche() {
		check(laenge);
		check(breite);
		double i = laenge * breite;
		return i;
	}

	/**
	 * Mit dieser Methode werden die eingegebenen Daten �berpf�ft.
	 */
	@Override
	public void check(double value) {
		if (value <= 0.0) {
			throw new IllegalArgumentException("Die eingegebenen Werte d�rfen nicht negativ sein.");
		}
	}

	@Override
	public double berechneUmfang() {
		double i = (laenge + breite) * 2;
		return i;
	}

}
