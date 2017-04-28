package erfassung;

import java.util.Scanner;

import modell.Dreieck;
/**
 * Diese Klasse dient zum Berechnen der Dreiecks Form. </br>
 * Ese werden folgende Methoden benutzt: </br>
 * {@link #eingabe()} </br>
 * {@link #getName()} </br>
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 */
public class DreieckBerechner implements Berechner {
	/**
	 * Diese Methode dient zur Eingabe der Daten durch den Benutzer.
	 */
	@Override
	public void eingabe() {
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie die Länge der ersten Seite ein:");
		double a = s.nextDouble();
		System.out.println("Bitte geben Sie die Länge der zweiten Seite ein:");
		double b = s.nextDouble();
		System.out.println("Bitte geben Sie die Länge der dritten Seite ein:");
		double c = s.nextDouble();
		s.close();
		
		try {
				Dreieck d = new Dreieck(a,b,c);
				System.out.println();
				System.out.println("Der Flächeninhalt beträgt: " + d.berechneFlaeche());
				System.out.println("Der Umfang beträgt: " + d.berechneUmfang());
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	/**
	 * Diese Methode gibt nur den Namen dieser Klasse zurück.
	 */
	@Override
	public String getName() {
		return "Dreieck";
	}

	
}
