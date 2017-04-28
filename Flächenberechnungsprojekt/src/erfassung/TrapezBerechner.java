package erfassung;

import java.util.Scanner;

import modell.Trapez;
/**
 * Diese Klasse dient zum Berechnen der Trapez Form. </br>
 * Ese werden folgende Methoden benutzt: </br>
 * {@link #eingabe()} </br>
 * {@link #getName()} </br>
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 */
public class TrapezBerechner implements Berechner {

	/**
	 * Diese Methode dient zur Eingabe der Daten durch den Benutzer.
	 */
	@Override
	public void eingabe() {
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie die Länge der Seite a ein.");
		double a = s.nextDouble();
		System.out.println("Bitte geben Sie die Länge der Seite c ein.");
		double c = s.nextDouble();
		System.out.println("Bitte geben Sie die Länge der Seite h ein.");
		double h = s.nextDouble();
		
		s.close();
		try{
			Trapez t = new Trapez(a,c,h);
			System.out.println();
			System.out.println("Der Flächeninhalt beträgt: " + t.berechneFlaeche());
			System.out.println("Der Umfang beträgt: " + t.berechneUmfang());
		}catch(IllegalArgumentException ex){
			System.out.println(ex.getMessage());
		}
	}
	/**
	 * Diese Methode gibt nur den Namen dieser Klasse zurück.
	 */
	@Override
	public String getName() {
		return "Trapez";
	}

}
