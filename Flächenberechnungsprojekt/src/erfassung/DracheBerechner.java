package erfassung;

import java.util.Scanner;

import modell.Drache;
/**
 * Diese Klasse dient zum Berechnen der Drachen Form. </br>
 * Ese werden folgende Methoden benutzt: </br>
 * {@link #eingabe()} </br>
 * {@link #getName()} </br>
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 */
public class DracheBerechner implements Berechner {

	/**
	 * Diese Methode dient zur Eingabe der Daten durch den Benutzer.
	 */
	@Override
	public void eingabe() {
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie die Länge der ersten Seitenlänge ein.");
		double seitenlaenge1 = s.nextDouble();
		System.out.println("Bitte geben Sie die Länge der zweiten Seitenlänge ein.");
		double seitenlaenge2 = s.nextDouble();
		System.out.println("Bitte geben Sie die Länge der ersten Diagonale ein.");
		double diagonale1 = s.nextDouble();
		s.close();
		try{
			Drache d = new Drache(seitenlaenge1, seitenlaenge2, diagonale1);
			System.out.println();
			System.out.println("Der Flächeninhalt beträgt: " + d.berechneFlaeche());
			System.out.println("Der Umfang beträgt: " + d.berechneUmfang());
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * Diese Methode gibt nur den Namen dieser Klasse zurück.
	 */
	@Override
	public String getName() {
		return "Drache";
	}

}
