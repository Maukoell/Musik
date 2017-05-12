package datenbankObjekte;

public class Song {
	int songID;
	String songName;
	double dauer;
	Interpret Interpret;
	CD cd;
	/**
	 * @param songID Die ID des Songs
	 * @param songName Der Name des Songs
	 * @param dauer Die Dauer des Songs
	 * @param interpret
	 * @param cd
	 */
	public Song(int songID, String songName, double dauer, Interpret interpret, CD cd) {
		super();
		this.songID = songID;
		this.songName = songName;
		this.dauer = dauer;
		this.Interpret = interpret;
		this.cd = cd;
	}
	/**
	 * @return the songID
	 */
	public int getSongID() {
		return songID;
	}
	/**
	 * @param songID the songID to set
	 */
	public void setSongID(int songID) {
		this.songID = songID;
	}
	/**
	 * @return the songName
	 */
	public String getSongName() {
		return songName;
	}
	/**
	 * @param songName the songName to set
	 */
	public void setSongName(String songName) {
		this.songName = songName;
	}
	/**
	 * @return the dauer
	 */
	public double getDauer() {
		return dauer;
	}
	/**
	 * @param dauer the dauer to set
	 */
	public void setDauer(double dauer) {
		this.dauer = dauer;
	}
	/**
	 * @return the interpret
	 */
	public Interpret getInterpret() {
		return Interpret;
	}
	/**
	 * @param interpret the interpret to set
	 */
	public void setInterpret(Interpret interpret) {
		Interpret = interpret;
	}
	/**
	 * @return the cd
	 */
	public CD getCd() {
		return cd;
	}
	/**
	 * @param cd the cd to set
	 */
	public void setCd(CD cd) {
		this.cd = cd;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Song [songID=" + songID + ", songName=" + songName + ", dauer=" + dauer + ", Interpret=" + Interpret
				+ ", cd=" + cd + "]";
	}
	
	
	
}
