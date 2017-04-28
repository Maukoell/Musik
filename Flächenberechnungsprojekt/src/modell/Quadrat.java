package modell;
/**Diese Klasse wird zum Erstellen eines Objektes Quadrat benötigt. </br>
 * Folgende Methoden werden benutzt:
 * 
 * {@link #berechneFlaeche()}</br>
 * {@link #berechneUmfang()} </br>
 * {@link #check()}</br> 
 * {@link #getLaenge()}</br>
 * {@link #setLaenge(double)}</br>
 * {@link #Quadrat(double)}</br>
 * 
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 *
 */
public class Quadrat implements Figur {
public double laenge;

	/**
	 * Diese Methode wird benötigt um im späteren Verlauf benötigt, </br>
	 * um ein Quadrat zu erzeugen
	 * @param laenge
	 */
	public Quadrat(double laenge) {
	check(laenge);
	this.laenge = laenge;
}
	/**
	 * Mit dieser Methode kann die Länge abgerufen werden.
	 * @return	länge
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
	 * Mit dieser Methode wird der Flächeninhalt des Quadrats berechnet.
	 */
	@Override
	public double berechneFlaeche() {
		check(laenge);
		double i = laenge * laenge;
		return i;
	}
	/**
	 * Mit dieser Methode werden die eingegebenen Daten überpfüft.
	 */
	@Override
	public void check(double value) {
		if (value <= 0) {
			throw new IllegalArgumentException("Der eingegebene Wert muss positiv sein!");
		}
	}
	/**
	 * Mit dieser Methode wird der Umfang des Quadrats berechnet.
	 */
	
	@Override
	public double berechneUmfang() {
		check(laenge);
		double i = laenge * 4;
		return i;
	}

}
