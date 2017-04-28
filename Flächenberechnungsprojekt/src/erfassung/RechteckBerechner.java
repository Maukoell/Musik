package erfassung;

import java.util.Scanner;

import modell.Rechteck;
/**
 * Diese Klasse dient zum Berechnen der Rauten Form. </br>
 * Ese werden folgende Methoden benutzt: </br>
 * {@link #eingabe()} </br>
 * {@link #getName()} </br>
 * @author Mauricio K�ll & Johannes Lindner
 * @version 1.0
 */
public class RechteckBerechner implements Berechner {
	/**
	 * Diese Methode dient zur Eingabe der Daten durch den Benutzer.
	 */
	@Override
	public void eingabe() {
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie die L�nge des Rechtecks ein:");
		double laenge = s.nextDouble();
		System.out.println("Bitte geben Sie die Breite des Rechtecks ein:");
		double breite = s.nextDouble();
		s.close();
		try {
			Rechteck r  = new Rechteck(laenge,breite);
			System.out.println();
			System.out.println("Der Fl�cheninhalt betr�gt: " + r.berechneFlaeche());
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	/**
	 * Diese Methode gibt nur den Namen dieser Klasse zur�ck.
	 */
	@Override
	public String getName() {
		return "Rechteck";
	}

}
