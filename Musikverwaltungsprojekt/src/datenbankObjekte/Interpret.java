package datenbankObjekte;
/**
 * Diese Klasse definiert den Interpreten. </br>
 * Sie beinhaltet folgende Methoden: </br> </br>
 * 
 * Konstruktoren: </br>
 * {@link #Interpret(String, String)} </br>
 * {@link #Interpret(int, String, String)} </br> </br>
 * 
 * Getters: </br>
 * {@link #getInterpretID()} </br>
 * {@link #getNachname()} </br>
 * {@link #getVorname()} </br> </br>
 * 
 * Setters: </br>
 * {@link #setInterpretID(int)} </br>
 * {@link #setNachname(String)} </br>
 * {@link #setVorname(String)} </br> </br>
 * 
 * ToString: </br>
 * {@link #toString()} </br>
 * 
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 */
public class Interpret {
	int InterpretID;
	String vorname;
	String nachname;
	/**
	 * Konstruktor für den Interpreten mit ID
	 * @param interpretID ID des Interpreten
	 * @param vorname Vorname des Interpreten
	 * @param nachname Nachname des Interpreten
	 */
	public Interpret(int interpretID, String nachname, String vorname) {
		this.InterpretID = interpretID;
		this.vorname = vorname;
		this.nachname = nachname;
	}
	/**
	 * Konstruktor für den Interpreten ohne ID
	 * @param nname Nachname des Interpreten
	 * @param vname Vorname des Interpreten
	 */
	public Interpret(String nname, String vname) {
		this.vorname = vname;
		this.nachname = nname;
	}
	/**
	 * @return the interpretID
	 */
	public int getInterpretID() {
		return InterpretID;
	}
	/**
	 * @param interpretID the interpretID to set
	 */
	public void setInterpretID(int interpretID) {
		InterpretID = interpretID;
	}
	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return nachname;
	}
	/**
	 * @param nachname the nachname to set
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Interpret [InterpretID=" + InterpretID + ", vorname=" + vorname + ", nachname=" + nachname + "]";
	}
	
	
}
