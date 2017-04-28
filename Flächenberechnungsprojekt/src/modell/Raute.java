package modell;
/**Diese Klasse wird zum Erstellen eines Objektes Raute ben�tigt. </br>
 * Folgende Methoden werden ben�tigt: </bd>
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
 * @author Mauricio K�ll & Johannes Lindner
 * @version 1.0
 *
 */
public class Raute implements Figur {
	private double laenge;
	private double hoehe;

	/**
	 * Diese Methode wird ben�tigt um im sp�teren Verlauf ben�tigt, </br>
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
	 * Mit dieser Methode kann die L�nge abgerufen werden. 
	 * @return	L�nge
	 */
	
	public double getLaenge() {
		return laenge;
	}
	
	/**
	 * Mit dieser Methode kann die L�nge festgelegt werden.
	 * @param laenge
	 */
	
	public void setLaenge(double laenge) {
		check(laenge);
		this.laenge = laenge;
	}
	
	/**
	 * Mit dieser Methode kann die H�he abgerufen werden.
	 * @return	H�he
	 */
	
	public double getHoehe() {
		return hoehe;
	}
		
	/**
	 * Mit dieser Methode kann die H�he festgelegt werden.
	 * @param hoehe
	 */
	
	public void setHoehe(double hoehe) {
		check(hoehe);
		this.hoehe = hoehe;
	}
	
	/**
	 * Mit dieser Methode kann der Fl�cheninhalt einer Raute berechnet werden.
	 */
	
	@Override
	public double berechneFlaeche() {
		check(hoehe);
		check(laenge);
		double i = laenge * hoehe;
		return i;
	}
	
	/**
	 * Mit dieser Methode werden die eingegebenen Daten �berpf�ft.
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
