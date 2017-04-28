package erfassung;

import java.util.Scanner;

import modell.Drache;
/**
 * Diese Klasse dient zum Berechnen der Drachen Form. </br>
 * Ese werden folgende Methoden benutzt: </br>
 * {@link #eingabe()} </br>
 * {@link #getName()} </br>
 * @author Mauricio K�ll & Johannes Lindner
 * @version 1.0
 */
public class DracheBerechner implements Berechner {

	/**
	 * Diese Methode dient zur Eingabe der Daten durch den Benutzer.
	 */
	@Override
	public void eingabe() {
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie die L�nge der ersten Seitenl�nge ein.");
		double seitenlaenge1 = s.nextDouble();
		System.out.println("Bitte geben Sie die L�nge der zweiten Seitenl�nge ein.");
		double seitenlaenge2 = s.nextDouble();
		System.out.println("Bitte geben Sie die L�nge der ersten Diagonale ein.");
		double diagonale1 = s.nextDouble();
		s.close();
		try{
			Drache d = new Drache(seitenlaenge1, seitenlaenge2, diagonale1);
			System.out.println();
			System.out.println("Der Fl�cheninhalt betr�gt: " + d.berechneFlaeche());
			System.out.println("Der Umfang betr�gt: " + d.berechneUmfang());
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * Diese Methode gibt nur den Namen dieser Klasse zur�ck.
	 */
	@Override
	public String getName() {
		return "Drache";
	}

}
