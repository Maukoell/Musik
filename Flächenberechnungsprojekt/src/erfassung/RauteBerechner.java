package erfassung;

import java.util.Scanner;

import modell.Raute;
/**
 * Diese Klasse dient zum Berechnen der Rauten Form. </br>
 * Ese werden folgende Methoden benutzt: </br>
 * {@link #eingabe()} </br>
 * {@link #getName()} </br>
 * @author Mauricio K�ll & Johannes Lindner
 * @version 1.0
 */
public class RauteBerechner implements Berechner {
	/**
	 * Diese Methode dient zur Eingabe der Daten durch den Benutzer.
	 */
	@Override
	public void eingabe() {
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie die L�nge der Raute ein:");
		double laenge = s.nextDouble();
		System.out.println("Bitte geben Sie die H�he der Raute ein:");
		double hoehe = s.nextDouble();	
		s.close();
		try {
			Raute r = new Raute(laenge,hoehe);
			System.out.println();
			System.out.println("Der Fl�cheninhalt betr�gt: " + r.berechneFlaeche());
			System.out.println("Der Umfang betr�gt: " + r.berechneUmfang());
		}catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	/**
	 * Diese Methode gibt nur den Namen dieser Klasse zur�ck.
	 */
	@Override
	public String getName() {
		return "Raute";
	}

	
	
}
