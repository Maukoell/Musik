package erfassung;

import java.util.Scanner;

import modell.Quadrat;
/**
 * Diese Klasse dient zum Berechnen der Quadrat Form. </br>
 * Ese werden folgende Methoden benutzt: </br>
 * {@link #eingabe()} </br>
 * {@link #getName()} </br>
 * @author Mauricio K�ll & Johannes Lindner
 * @version 1.0
 */
public class QuadratBerechner implements Berechner {

	/**
	 * Diese Methode dient zur Eingabe der Daten durch den Benutzer.
	 */
	@Override
	public void eingabe() {
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie die Seitenl�nge ein:");
		double laenge = s.nextDouble();
		s.close();
		try {
			Quadrat q = new Quadrat(laenge);
			System.out.println();
			System.out.println("Der Fl�cheninhalt betr�gt: " + q.berechneFlaeche());
			System.out.println("Der Umfang betr�gt: " + q.berechneUmfang());
		}catch(IllegalArgumentException ex){
			System.out.println(ex.getMessage());
		}
	}
	/**
	 * Diese Methode gibt nur den Namen dieser Klasse zur�ck.
	 */
	@Override
	public String getName() {
		return "Quadrat";
	}

	

}
