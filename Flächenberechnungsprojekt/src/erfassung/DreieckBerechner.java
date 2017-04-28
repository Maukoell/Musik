package erfassung;

import java.util.Scanner;

import modell.Dreieck;
/**
 * Diese Klasse dient zum Berechnen der Dreiecks Form. </br>
 * Ese werden folgende Methoden benutzt: </br>
 * {@link #eingabe()} </br>
 * {@link #getName()} </br>
 * @author Mauricio K�ll & Johannes Lindner
 * @version 1.0
 */
public class DreieckBerechner implements Berechner {
	/**
	 * Diese Methode dient zur Eingabe der Daten durch den Benutzer.
	 */
	@Override
	public void eingabe() {
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie die L�nge der ersten Seite ein:");
		double a = s.nextDouble();
		System.out.println("Bitte geben Sie die L�nge der zweiten Seite ein:");
		double b = s.nextDouble();
		System.out.println("Bitte geben Sie die L�nge der dritten Seite ein:");
		double c = s.nextDouble();
		s.close();
		
		try {
				Dreieck d = new Dreieck(a,b,c);
				System.out.println();
				System.out.println("Der Fl�cheninhalt betr�gt: " + d.berechneFlaeche());
				System.out.println("Der Umfang betr�gt: " + d.berechneUmfang());
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	/**
	 * Diese Methode gibt nur den Namen dieser Klasse zur�ck.
	 */
	@Override
	public String getName() {
		return "Dreieck";
	}

	
}
