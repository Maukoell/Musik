package modell;
/**Diese Klasse wird zum Erstellen eines Objektes Raute benötigt. </br>
 * Folgende Methoden werden benötigt: </bd>
 * 
 * {@link #Raute(double, double)} </bd>
 * {@link #getLaenge()} </bd>
 * {@link #setLaenge(double)} </bd>
 * {@link #getHoehe()} </bd>
 * {@link #setHoehe(double)} </bd>
 * {@link #berechneFlaeche()} </bd>
 * {@link #berechneUmfang()} </br>
 * {@link #check(double)} </bd>
 * 
 * 
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 *
 */
public class Raute implements Figur {
	private double laenge;
	private double hoehe;

	/**
	 * Diese Methode wird benötigt um im späteren Verlauf benötigt, </br>
	 * um eine Raute zu erzeugen
	 * @param laenge
	 * @param hoehe
	 */
	
	public Raute(double laenge, double hoehe) {
		check(hoehe);
		check(laenge);
		this.laenge = laenge;
		this.hoehe = hoehe;
	}

	/**
	 * Mit dieser Methode kann die Länge abgerufen werden. 
	 * @return	Länge
	 */
	
	public double getLaenge() {
		return laenge;
	}
	
	/**
	 * Mit dieser Methode kann die Länge festgelegt werden.
	 * @param laenge
	 */
	
	public void setLaenge(double laenge) {
		check(laenge);
		this.laenge = laenge;
	}
	
	/**
	 * Mit dieser Methode kann die Höhe abgerufen werden.
	 * @return	Höhe
	 */
	
	public double getHoehe() {
		return hoehe;
	}
		
	/**
	 * Mit dieser Methode kann die Höhe festgelegt werden.
	 * @param hoehe
	 */
	
	public void setHoehe(double hoehe) {
		check(hoehe);
		this.hoehe = hoehe;
	}
	
	/**
	 * Mit dieser Methode kann der Flächeninhalt einer Raute berechnet werden.
	 */
	
	@Override
	public double berechneFlaeche() {
		check(hoehe);
		check(laenge);
		double i = laenge * hoehe;
		return i;
	}
	
	/**
	 * Mit dieser Methode werden die eingegebenen Daten überpfüft.
	 */
	
	@Override
	public void check(double value) {
	if (value <= 0) {
		throw new IllegalArgumentException("Der eingegebene Wert darf nicht negativ sein!");
	}
	}
	
	/**
	 * Mit dieser Merhode wird der Umfang berechnet.
	 */
	@Override
	public double berechneUmfang() {
		check(hoehe);
		check(laenge);
		double i = 4 * laenge;
		return i;
	}

}
