package modell;
/**Diese Klasse wird zum Erstellen eines Objektes Dreieck benötigt. </br>
 * Folgenden Methode werden benutzt: </br>
 * 
 * {@link #Dreieck(double, double, double)}</br>
 * {@link #berechneFlaeche()} </br>
 * {@link #berechneUmfang()} </br>
 * {@link #getA()} </br>
 * {@link #getB()} </br>
 * {@link #getC()} </br>
 * {@link #setA(double)} </br>
 * {@link #setB(double)} </br>
 * {@link #setC(double)} </br>
 * 
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 *
 */
public class Dreieck implements Figur {
	private double a;
	private double b;
	private double c;
	
	/**
	 * Diese Methode wird benötigt um im späteren Verlauf benötigt, </br>
	 * um ein Dreieck zu erzeugen
	 * @param a
	 * @param b
	 * @param c
	 */
	
	public Dreieck(double a, double b, double c) {
		check(a);
		check(b);
		check(c);
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		check(a);
		this.a = a;
	}

	/**
	 * Mit dieser Methode kann die Seite b des Dreiecks abgerufen werden.
	 * @return
	 */
	
	public double getB() {
		return b;
	}

	/**
	 * Mit dieser Methode kann die Seite b des Dreiecks festgelegt werden.
	 * @param b
	 */
	
	public void setB(double b) {
		check(b);
		this.b = b;
	}
	
	/**
	 * Mit dieser Methode kann die Seite c des Dreiecks abgerufen werden.
	 * @return c
	 */
	
	public double getC() {
		return c;
	}

	/**
	 * Mit dieser Methode kann die Seite c des Dreiecks festgelegt werden.
	 * @param c
	 */
	
	public void setC(double c) {
		check(c);
		this.c = c;
	}
	
	/**
	 * Mit dieser Methode kann der Flächeninhalt eines Dreiecks berechnet werden.
	 */
	
	@Override
	public double berechneFlaeche() {
		check(a);
		check(b);
		check(c);
		double s = (a + b + c) / 2;
		double x = (s*(s-a)*(s-b)*(s-c));
		double i = Math.sqrt(x);
		return i;
	}
	
	/**
	 * Mit dieser Methode werden die eingegebenen Daten überpfüft.
	 */
	
	@Override
	public void check(double value) {
		if (value <= 0.0) {
			throw new IllegalArgumentException("Die eingegebenen Werte dürfen nicht negativ sein!");
		}
	}

	@Override
	public double berechneUmfang() {
		check(a);
		check(b);
		check(c);
		double i = a + b + c;
		return i;
	}

}
