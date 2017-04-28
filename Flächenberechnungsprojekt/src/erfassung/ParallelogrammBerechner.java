package erfassung;

import java.util.Scanner;

import modell.Parallelogramm;
/**
 * Diese Klasse dient zum Berechnen der Parallelogramm Form. </br>
 * Ese werden folgende Methoden benutzt: </br>
 * {@link #eingabe()} </br>
 * {@link #getName()} </br>
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 */
public class ParallelogrammBerechner implements Berechner {


	
	/**
	 * Diese Methode dient zur Eingabe der Daten durch den Benutzer.
	 */
	@Override
	public void eingabe() {
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie die Länge ein.");
		double laenge = s.nextDouble();
		System.out.println("Bitte geben Sie die Höhe ein.");
		double hoehe = s.nextDouble();
		s.close();
		
		try{
			Parallelogramm p = new Parallelogramm(laenge, hoehe);
			System.out.println();
			System.out.println("Der Flächeninhalt beträgt: " + p.berechneFlaeche());
			System.out.println("Der Umfang beträgt: " + p.berechneUmfang());
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	/**
	 * Diese Methode gibt nur den Namen dieser Klasse zurück.
	 */
	@Override
	public String getName() {
		return "Parallelogramm";
	}

}
