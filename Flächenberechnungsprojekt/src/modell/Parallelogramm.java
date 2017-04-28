package modell;
/**Diese Klasse wird zum Erstellen eines Objektes Parallelogramm ben�tigt. </br>
 * Folgende Methoden werden benutzt: </br>
 * {@link #berechneFlaeche()} </br>
 * {@link #berechneUmfang()} </br>
 * {@link #check()} </br> 
 * {@link #Parallelogramm(double, double)} </br>
 * {@link #getHoehe()} </br>
 * {@link #getLaenge()} </br>
 * {@link #setHoehe(double)} </br>
 * {@link #setLaenge(double)} </br>
 * 
 * @author Mauricio K�ll & Johannes Lindner
 * @version 1.0
 *
 */
public class Parallelogramm implements Figur {
	private double laenge;
	private double hoehe;

	public Parallelogramm(double laenge, double hoehe) {
		check(laenge);
    	check(hoehe);
		this.laenge = laenge;
		this.hoehe = hoehe;
	}

	public double getLaenge() {
		return laenge;
	}

	public void setLaenge(double laenge) {
		check(laenge);
		this.laenge = laenge;
	}

	public double getHoehe() {
		return hoehe;
	}

	/**
	 * Mit dieser Methode wird die H�he festgelegt.
	 * @param hoehe
	 */
	
	public void setHoehe(double hoehe) {
		check(hoehe);
		this.hoehe = hoehe;
	}
	/**
	 * Mit dieser Methode wird der Fl�cheninhalt des Parallelogramms berechnet.
	 */
    @Override
	public double berechneFlaeche() {
    	check(laenge);
    	check(hoehe);
		double i = laenge * hoehe;
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
		check(laenge);
    	check(hoehe);
		double i = (laenge + hoehe) * 2;
		return i;
	}

}
