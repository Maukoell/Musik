package erfassung;

import java.util.HashMap;
import java.util.Scanner;
/**
 * Diese Klasse wird benötigt um das Programm auszuführen. </br>
 * Dabei werden durch eine HashMap die verschiedenen Möglichkeiten auswählbar </br>
 * und nach Eingabe der Daten berechnet. </br>
 * Folgende Methoden werden verwendet: </br>
 * {@link #displayMenu()}} </br>
 * {@link #getReader(String)} </br>
 * {@link #initialize()} </br>
 * {@link #main(String[])} 
 * 
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 */
public class Application {
	private HashMap<String, Berechner> hmap = new HashMap<String, Berechner>();
	/**
	 * In dieser Methode werden die verschiedenen Formen in die HashMap initialisiert.
	 */
	
	private void initialize() {
		hmap.put("Kreis", new KreisBerechner());
		hmap.put("Quadrat", new QuadratBerechner());
		hmap.put("Raute", new RauteBerechner());
		hmap.put("Rechteck", new RechteckBerechner());
		hmap.put("Dreieck", new DreieckBerechner());
		hmap.put("Drache", new DracheBerechner());
		hmap.put("Parallelogramm", new ParallelogrammBerechner());
		hmap.put("Trapez", new TrapezBerechner());
	}
	/**
	 * Diese Methode dient zur Ausgabe der Eingabemöglichkeiten. </br>
	 * Es werden alle möglichen Figuren aufgezählt.
	 */
	private void displayMenu() {
		for (String code : hmap.keySet()) {
			System.out.println("Für " + hmap.get(code).getName() + " geben Sie " + code + " ein.");
		}
	}
	/**
	 * Diese Methode ermöglicht die Eingabe der Daten, </br>
	 * indem die Form eingegeben wird.
	 * @param Die Form welche berechnet werden soll
	 * @return Die Eingabe für die Daten für die Berechnung
	 */
	private Berechner getReader(String code) {
		if(hmap.containsKey(code)) {
			return hmap.get(code);
		}return null;
	}
	
	/**
	 * Dies ist die Main Methode. </br>
	 * Ohne sie kann das Programm nicht ausgeführt werden.
	 * @param args
	 */
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Application app = new Application();
		app.initialize();
		app.displayMenu();
		String c = s.nextLine();
		Berechner rechner = app.getReader(c);
		if (rechner == null) {
			System.out.println("Ungültige Eingabe");
		}
		else {
			rechner.eingabe();
		}
		s.close();
	}
}
