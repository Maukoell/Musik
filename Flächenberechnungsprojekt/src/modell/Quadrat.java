package modell;
/**Diese Klasse wird zum Erstellen eines Objektes Quadrat ben�tigt. </br>
 * Folgende Methoden werden benutzt:
 * 
 * {@link #berechneFlaeche()}</br>
 * {@link #berechneUmfang()} </br>
 * {@link #check()}</br> 
 * {@link #getLaenge()}</br>
 * {@link #setLaenge(double)}</br>
 * {@link #Quadrat(double)}</br>
 * 
 * @author Mauricio K�ll & Johannes Lindner
 * @version 1.0
 *
 */
public class Quadrat implements Figur {
public double laenge;

	/**
	 * Diese Methode wird ben�tigt um im sp�teren Verlauf ben�tigt, </br>
	 * um ein Quadrat zu erzeugen
	 * @param laenge
	 */
	public Quadrat(double laenge) {
	check(laenge);
	this.laenge = laenge;
}
	/**
	 * Mit dieser Methode kann die L�nge abgerufen werden.
	 * @return	l�nge
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
	 * Mit dieser Methode wird der Fl�cheninhalt des Quadrats berechnet.
	 */
	@Override
	public double berechneFlaeche() {
		check(laenge);
		double i = laenge * laenge;
		return i;
	}
	/**
	 * Mit dieser Methode werden die eingegebenen Daten �berpf�ft.
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
