package modell;
/**
 * Dieses Interface dient als Basis für alle Figuren,</br>
 *  mit den Methoden:</br>
 * 
 * {@link #berechneFlaeche()} </br>
 * {@link #check()} </br>
 * 
 * 
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 */
public interface Figur {
	/**
	 * Diese Methode dient zum Berechnen der Fläche einer Figur.
	 * @return Fläche der Figur
	 */
	double berechneFlaeche();
	/**
	 * Diese Methode dient zum Überpfüfen der Eingaben
	 * @throws IllegalArgumentException 
	 */

	void check(double value);
	
	/**
	 * Diese Methode dient zum Berechnen der Fläche einer Figur.
	 * @return Umfang der Figur
	 */
	double berechneUmfang();
	
//	double berechneVolumen();
}
