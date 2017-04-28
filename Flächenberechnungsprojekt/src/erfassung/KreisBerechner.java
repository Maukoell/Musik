package erfassung;
import java.util.Scanner;

import modell.Kreis;
/**
 * Diese Klasse dient zum Berechnen der Kreis Form. </br>
 * Ese werden folgende Methoden benutzt: </br>
 * {@link #eingabe()} </br>
 * {@link #getName()} </br>
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 */
public class KreisBerechner implements Berechner{
	/**
	 * Diese Methode dient zur Eingabe der Daten durch den Benutzer.
	 */

	@Override
	public void eingabe() {
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie den Radius ein:");
		double radius = s.nextDouble();
		s.close();
		try {
			Kreis k = new Kreis(radius);
			System.out.println();
			System.out.println("Der Flächeninhalt beträgt: " + k.berechneFlaeche());
			System.out.println("Der Umfang beträgt: " + k.berechneUmfang());
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	/**
	 * Diese Methode gibt nur den Namen dieser Klasse zurück.
	 */
	public String getName() {
		return "Kreis";
	}
}
