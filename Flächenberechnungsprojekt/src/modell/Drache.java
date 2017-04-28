package modell;
/**Diese Klasse wird zum Erstellen eines Objektes Drache benötigt. </br>
 * 
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 *
 */
public class Drache implements Figur {
	private double seitenlaenge1;
	private double seitenlaenge2;
	private double diagonale1;
	
	
	public Drache(double seitenlaenge1, double seitenlaenge2, double diagonale1) {
		check(seitenlaenge1);
		check(seitenlaenge2);
		check(diagonale1);
		this.seitenlaenge1 = seitenlaenge1;
		this.seitenlaenge2 = seitenlaenge2;
		this.diagonale1 = diagonale1;
	}

	

	public double getSeitenlaenge1() {
		return seitenlaenge1;
	}



	public void setSeitenlaenge1(double seitenlaenge1) {
		check(seitenlaenge1);
		this.seitenlaenge1 = seitenlaenge1;
	}



	public double getSeitenlaenge2() {
		return seitenlaenge2;
	}



	public void setSeitenlaenge2(double seitenlaenge2) {
		check(seitenlaenge2);
		this.seitenlaenge2 = seitenlaenge2;
	}



	@Override
	public double berechneFlaeche() {
		check(seitenlaenge1);
		check(seitenlaenge2);
		check(diagonale1);
		return 1/2* Math.sqrt(2*Math.pow( seitenlaenge1, 2)*Math.pow(seitenlaenge2,2)+2*Math.pow(seitenlaenge1,2)*Math.pow(diagonale1,2)+2*Math.pow(seitenlaenge2, 2)*Math.pow(diagonale1, 2)-Math.pow(seitenlaenge1,4)-Math.pow(seitenlaenge2,4)-Math.pow(diagonale1,4));      
	}

	@Override
	public void check(double value) {
		if (value <= 0.0) {
			throw new IllegalArgumentException("Die eingegebenen Werte dürfen nicht negativ sein!");
		}
	}

	@Override
	public double berechneUmfang() {
		check(seitenlaenge1);
		check(seitenlaenge2);
		check(diagonale1);
		return 2*seitenlaenge1+2*seitenlaenge2;
	}

}
