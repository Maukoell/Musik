package erfassung;
/**
 * Dieses Interface dient als Basis für die Berechner der verschiedenen Formen.</br>
 * Es werden die folgenden Methoden benutzt: </br>
 * {@link #getName()} </br>
 * {@link #eingabe()} </br>
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 */
public interface Berechner {
	public void eingabe();
	
	public String getName();
}
