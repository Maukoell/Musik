package modell;
/**Diese Klasse wird zum Erstellen eines Objektes Trapez benötigt. </br>
 * 
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 *
 */
public class Trapez implements Figur {
	private double a;
	private double c;
	private double h;

	public Trapez(double a, double c, double h) {
		check(a);
		check(c);
		check(h);
		this.a = a;
		this.c = c;
		this.h = h;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		
		this.a = a;
	}

	public double getC() {
		return c;
	}

	public void setc(double c) {
		
		this.c = c;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		
		this.h = h;
	}

	@Override
	public double berechneFlaeche() {
		check(a);
		check(c);
		check(h);
		double i = (a + c)/2 *h;
		return i;
	}

	@Override
	public void check(double value) {
		if (value <= 0.0) {
			throw new IllegalArgumentException("Die eingegebenen Werte dürfen nicht negativ sein.");
		}
	}

	@Override
	public double berechneUmfang() {
		check(a);
		check(c);
		check(h);
		double i= (a + c) + (2 * h);
		return i;
	}

}
