package datenbankObjekte;

import java.sql.Date;
/**
 * Diese Klasse definiert den Interpreten. </br>
 * Sie beinhaltet folgende Methoden: </br> </br>
 * 
 * Konstruktor: </br>
 * {@link #CD(int, String, String, Date)} </br> </br>
 * 
 * Getters: </br>
 * {@link #getCDID()} </br>
 * {@link #getName()} </br>
 * {@link #getVerlag()} </br>
 * {@link #getErschDatum()} </br> </br>
 * 
 *  Setters: </br>
 *  {@link #setCDID(int)} </br>
 *  {@link #setName(String)} </br>
 *  {@link #setVerlag(String)} </br>
 *  {@link #setErschDatum(Date)} </br> </br>
 *  
 *  ToString: </br>
 *  {@link #toString()} </br>
 * 
 * 
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 */

public class CD {
		int CDID;
		String name;
		String verlag;
		Date erschDatum;
		/**
		 * Dies ist der Konstruktor der CD
		 * @param cDID die ID der CD
		 * @param name der Name der CD
		 * @param verlag der Verlag der CD
		 * @param erscheinungsdatum das Erscheinungsdatum der CD
		 */
		public CD(int cDID, String name, String verlag, Date erschDatum) {
			super();
			CDID = cDID;
			this.name = name;
			this.verlag = verlag;
			this.erschDatum = erschDatum;
		}
		/**
		 * @return the cDID
		 */
		public int getCDID() {
			return CDID;
		}
		/**
		 * @param cDID the cDID to set
		 */
		public void setCDID(int cDID) {
			CDID = cDID;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the verlag
		 */
		public String getVerlag() {
			return verlag;
		}
		/**
		 * @param verlag the verlag to set
		 */
		public void setVerlag(String verlag) {
			this.verlag = verlag;
		}
		/**
		 * @return the erscheinungsdatum
		 */
		public Date getErschDatum() {
			return erschDatum;
		}
		/**
		 * @param erscheinungsdatum the erscheinungsdatum to set
		 */
		public void setErschDatum(Date erscheinungsdatum) {
			this.erschDatum = erscheinungsdatum;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "CD [CDID=" + CDID + ", name=" + name + ", verlag=" + verlag + ", erscheinungsdatum="
					+ erschDatum + "]";
		}
		
		
		
}
