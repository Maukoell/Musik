package datenbankObjekte;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Diese Klasse dient als Schnittstelle</br>
 * zwischen dem Java-Programm und der MySQL Datenbank. </br>
 * Die Klasse beinhaltet folgende Methoden: </br> </br>
 * 
 * Eine Methode zur Herstellung der Verbindung und zum Trennen der Verbindung zur Datenbank: </br>
 * {@link #closeConnection(Connection)} </br>
 * {@link #getConnection()} </br> </br>
 * 
 * Methoden zum Lesen aus der Datenbank: </br>
 * 
 * {@link #getCDByID(Connection, int)} </br>
 * {@link #getInterpretByID(Connection, int)} </br>
 * {@link #getSongById(Connection, int)} </br> </br>
 * 
 * Methoden zum Löschen aus der Datenbank: </br> 
 * 
 * {@link #deleteCDByID(Connection, int)} </br>
 * {@link #deleteInterpretByID(Connection, int)} </br>
 * {@link #deleteSongByID(Connection, int)} </br>
 * 
 * @author Mauricio Köll & Johannes Lindtner
 * @version 1.0
 */
public class DBManager {
	String url = "jdbc:mysql://localhost/musikdatenbank";
	String username = "root";
	String password = "";
	
	/**
	 * Diese Methode wird benötigt um eine Verbindung zur Datenbank herzustellen.
	 * @return Die Verbindung zur Datenbank
	 */
public Connection getConnection() {
		Connection con = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
	}catch(Exception ex) {
		ex.printStackTrace();
		System.exit(-1);
	}
		return con;
	}
	/**
	 * Diese Methode trennt die Verbindung zur Datenbank.
	 * @param con Die Verbindung zur Datenbank welche getrennt werden soll
	 */
public void closeConnection(Connection con) {
		try{
			con.close();
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
			
		}
	}
	/**
	 * Diese Methode gibt ein Interpret Objekt aus der Datenbank zurück, </br>
	 * welches durch die InterpretID ausgewählt wird.
	 * @param con Die Verbindung zur Datenbank
	 * @param InterpretID Die ID des Interpreten welcher Ausgelesen werden soll
	 * @return das Interpret Objekt
	 * @throws SQLException
	 */
public Interpret getInterpretByID(Connection con, int InterpretID) throws SQLException {
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		Interpret p = null;
		
		try {
			String sql = "Select InterpretID, Vorname, Nachname " + "from Interpret where InterpretID = ?";
			stm = con.prepareStatement(sql);
			stm.setInt(1, InterpretID);
			rs = stm.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String vn = rs.getString(2);
				String nn = rs.getString(3);
				
				p = new Interpret(id,vn,nn);
				
			}
		} finally {/* 	fals eine Exception auftritt werden rs und stm wieder geschlossen(aufgeräumt) */
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
		}
		return p;
	}
	/**
	 * Diese Methode gibt ein CD Objekt aus der Datenbank zurück, </br>
	 * welches durch die CDID ausgewählt wird.
	 * @param con Die Verbindung zur Datenbank
	 * @param CDID Die ID der CD
	 * @return Ein CD Objekt
	 * @throws SQLException
	 */
public CD getCDByID(Connection con, int CDID) throws SQLException {
	PreparedStatement stm = null;
	ResultSet rs = null;
	CD p = null;
	
	try {
		String sql = "Select CDID, Name, Verlag, ErschDatum " 
				+ "from CD where CDID = ?";
		stm = con.prepareStatement(sql);
		stm.setInt(1, CDID);
		rs = stm.executeQuery();
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String verlag = rs.getString(3);
			Date ErschDatum = rs.getDate(4);
			
			p = new CD(id,name,verlag,ErschDatum);
			
		}
	} finally {/* 	fals eine Exception auftritt werden rs und stm wieder geschlossen(aufgeräumt) */
		if (rs != null) {
			rs.close();
		}
		if (stm != null) {
			stm.close();
		}
	}
	
	return p;
}
	/**
	 * Diese Methode gibt ein Song Objekt aus der Datenbank zurück, </br>
	 * welches durch die SongID ausgewählt wird.
	 * @param con Die Verbindung zur Datenbank
	 * @param SongID Die ID des Songs
	 * @return Ein Song Objekt
	 * @throws SQLException
	 */

public Song getSongById(Connection con, int SongID) throws SQLException {
	PreparedStatement stm = null;
	ResultSet rs = null;
	Song s = null;
	
	try {
		String sql = "Select SongID, Name, Dauer, Interpret, CD " + "from Song where SongID = ?";
		stm = con.prepareStatement(sql);
		stm.setInt(1, SongID);
		rs = stm.executeQuery();
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			Double dauer = rs.getDouble(3);
			Interpret interpret = getInterpretByID(con, rs.getInt(4));
			CD cd = getCDByID(con, rs.getInt(5));
			
			s = new Song(id,name,dauer,interpret,cd);
			
		}
	} finally {/* 	fals eine Exception auftritt werden rs und stm wieder geschlossen(aufgeräumt) */
		if (rs != null) {
			rs.close();
		}
		if (stm != null) {
			stm.close();
		}
	}
	
	return s;
}
	/**
	 * Diese Methode dient zum Löschen eines Interpret Objektes aus der Datenbank.
	 * @param con Die Verbindung zur Datenbank
	 * @param InterpretID Die ID des zu löschenden Objektes
	 * @throws SQLException
	 */

public void deleteInterpretByID(Connection con, int InterpretID) throws SQLException {
	
	PreparedStatement stm = null;
	
	try {
		String sql = "Delete from Interpret "
						+ "where InterpretID = ?";
		stm = con.prepareStatement(sql);
		stm.setInt(1, InterpretID);
		stm.executeUpdate();
		
	}finally {/* 	fals eine Exception auftritt werden rs und stm wieder geschlossen(aufgeräumt) */
			if (stm != null) {
				stm.close();
			}}
}
	/**
	 * Diese Methode dient zum Löschen eines CD Objektes aus der Datenbank.
	 * @param con Die Verbindung zur Datenbank.
	 * @param CDID Die ID des zu löschenden Objektes
	 * @throws SQLException
	 */

public void deleteCDByID(Connection con, int CDID) throws SQLException {
	
	PreparedStatement stm = null;
	
	try {
		String sql = "Delete from CD "
						+ "where CDID = ?";
		stm = con.prepareStatement(sql);
		stm.setInt(1, CDID);
		stm.executeUpdate();
		
	}finally {/* 	fals eine Exception auftritt werden rs und stm wieder geschlossen(aufgeräumt) */
			if (stm != null) {
				stm.close();
			}}
}
	/**
	 * Diese Methode dient zum Löschen eines Song Objektes aus der Datenbank.
	 * @param con Die Verbindung zur Datenbank.
	 * @param SongID Die ID des zu löschenden Objektes
	 * @throws SQLException
	 */

public void deleteSongByID(Connection con, int SongID) throws SQLException {
PreparedStatement stm = null;
	
	try {
		String sql = "Delete from Song "
						+ "where SongID = ?";
		stm = con.prepareStatement(sql);
		stm.setInt(1, SongID);
		stm.executeUpdate();
		
	}finally {/* 	fals eine Exception auftritt werden rs und stm wieder geschlossen(aufgeräumt) */
			if (stm != null) {
				stm.close();
			}}
}
	/**
	 * Diese Methode dient zum Einfügen eines Interpret Objektes in die Datenbank.
	 * @param con Die Verbindung zur Datenbank
	 * @param p Das Interpret Objekt
	 * @throws SQLException
	 */

public void insertInterpret(Connection con, Interpret p) throws SQLException {
	
	PreparedStatement stm = null;
	
	try {
		
		String sql = "Insert into Interpret values"
						+ "(?," + "'"+ p.getNachname() +"'," + "'"+ p.getVorname() +"')";
		stm = con.prepareStatement(sql);
		stm.setInt(1, p.getInterpretID());
	//	stm.setString(1, p.getNachname());
	//	stm.setString(1, p.getVorname());
		stm.executeUpdate();
		
	}finally {/* 	fals eine Exception auftritt werden rs und stm wieder geschlossen(aufgeräumt) */
			if (stm != null) {
				stm.close();
			}}
}
	/**
	 * Diese Methode dient zum Einfügen eines CD Objektes in die Datenbank.
	 * @param con Die Verbindung zur Datenbank
	 * @param p Ein CD Objekt
	 * @throws SQLException
	 */

public void insertCD(Connection con, CD p) throws SQLException {
	
	PreparedStatement stm = null;
	
	try {
		String sql = "Insert into CD values"
						+ "("+ p.getCDID() +"," + "'"+ p.getName() + "',"+"'"+ p.getVerlag() +"','" + p.getErschDatum() + "')";
		stm = con.prepareStatement(sql);
		stm.executeUpdate();
		
	}finally {/* 	fals eine Exception auftritt werden rs und stm wieder geschlossen(aufgeräumt) */
			if (stm != null) {
				stm.close();
			}}
}
	/**
	 * Diese Methode dient zum Einfügen eines Song Objektes in die Datenbank.
	 * @param con Die Verbindung zur Datenbank
	 * @param s Ein Song Objekt
	 * @throws SQLException
	 */
public void insertSong(Connection con, Song s) throws SQLException {
PreparedStatement stm = null;
	
	try {
		
		String sql2 = "Insert into Song values"
						+ "("+s.getSongID()+"," + "'"+ s.getSongName() + "',"+" "+ s.getDauer() +" ," + s.getInterpret().getInterpretID() + "," + s.getCd().getCDID() + ")";
		stm = con.prepareStatement(sql2);
		stm.executeUpdate();
		
	}finally {/* 	fals eine Exception auftritt werden rs und stm wieder geschlossen(aufgeräumt) */
			if (stm != null) {
				stm.close();
			}}
}


}
