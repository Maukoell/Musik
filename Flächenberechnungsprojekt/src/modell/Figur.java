package modell;
/**
 * Dieses Interface dient als Basis f�r alle Figuren,</br>
 *  mit den Methoden:</br>
 * 
 * {@link #berechneFlaeche()} </br>
 * {@link #check()} </br>
 * 
 * 
 * @author Mauricio K�ll & Johannes Lindner
 * @version 1.0
 */
public interface Figur {
	/**
	 * Diese Methode dient zum Berechnen der Fl�che einer Figur.
	 * @return Fl�che der Figur
	 */
	double berechneFlaeche();
	/**
	 * Diese Methode dient zum �berpf�fen der Eingaben
	 * @throws IllegalArgumentException 
	 */

	void check(double value);
	
	/**
	 * Diese Methode dient zum Berechnen der Fl�che einer Figur.
	 * @return Umfang der Figur
	 */
	double berechneUmfang();
	
//	double berechneVolumen();
}
