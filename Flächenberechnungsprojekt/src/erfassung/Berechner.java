package erfassung;
/**
 * Dieses Interface dient als Basis f�r die Berechner der verschiedenen Formen.</br>
 * Es werden die folgenden Methoden benutzt: </br>
 * {@link #getName()} </br>
 * {@link #eingabe()} </br>
 * @author Mauricio K�ll & Johannes Lindner
 * @version 1.0
 */
public interface Berechner {
	public void eingabe();
	
	public String getName();
}
