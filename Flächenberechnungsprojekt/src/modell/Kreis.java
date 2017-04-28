package modell;

/**Diese Klasse wird zum Erstellen eines Objektes Kreis benötigt. </br>
 * Folgende Methoden werden benötigt: </br>
 * {@link #berechneFlaeche()}</br>
 * {@link #check()}</br>
 * {@link #getRadius()}</br>
 * {@link #Kreis()}</br>
 * {@link #setRadius(double)}</br>
 * 
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 *
 */
public class Kreis implements Figur {
	private double radius;

	/**
	 * Diese Methode wird benötigt um im späteren Verlauf benötigt, </br>
	 * um einen Kreis zu erzeugen
	 * @param radius
	 */
	public Kreis(double radius) {
		check(radius);
		this.radius = radius;
	}

	/**
	 * Mit dieser Methode kann der Radius abgerufen werden.
	 * @return Gibt den Radius zurück
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Mit dieser Methode kann der Radius gesetzt werden.
	 * @param radius
	 * @throws Illegal
	 */
	public void setRadius(double radius) {
		check(radius);
		this.radius = radius;
	}

	/**
	 * Mit dieser Methode wird der Flächeninhalt des Kreises berechnet.
	 */
	@Override
	public double berechneFlaeche() {
		check(radius);
		double i = radius * radius * Math.PI;
		return i;
	}
	/**
	 * Mit dieser Methode werden die eingegebenen Daten überpfüft.
	 */
	@Override
	public void check(double value) {
		if(value <= 0.0) {
			throw new IllegalArgumentException("Der eingegebene Wert muss positiv sein.");
		}
	}

	@Override
	public double berechneUmfang() {
		check(radius);
		double i = radius * Math.PI * 2;
		return i;
	}

}
