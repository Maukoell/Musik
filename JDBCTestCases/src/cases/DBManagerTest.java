package cases;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datenbankObjekte.CD;
import datenbankObjekte.DBManager;
import datenbankObjekte.Interpret;
import datenbankObjekte.Song;


public class DBManagerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInterpret() throws SQLException {
		DBManager dbm = new DBManager();
		Connection con = dbm.getConnection();
		Interpret i1 = new Interpret(9,"Hans", "Hans");
		dbm.insertInterpret(con, i1);
		Interpret i2 = dbm.getInterpretByID(con, 9);
		String s1 = i1.toString();
		String s2 = i2.toString();
		assertEquals(s1, s2);
		dbm.deleteInterpretByID(con, 9);
		
	
	}
	
	@Test
	public void testCD() throws SQLException {
		DBManager dbm = new DBManager();
		Connection con = dbm.getConnection();
		CD c1 = new CD(150, "More Life", "OVO", new Date(2017-03-18));
		dbm.insertCD(con, c1);
		CD c2 = dbm.getCDByID(con, 150);
		String s1 = c1.toString();
		String s2 = c2.toString();
		assertEquals(s1,s2);
		dbm.deleteCDByID(con, 150);
	}
	
	@Test
	public void testSong() throws SQLException {
		DBManager dbm = new DBManager();
		Connection con = dbm.getConnection();
		CD c1 = new CD(100, "More Life", "OVO",  Date.valueOf("2017-03-18"));
		dbm.insertCD(con, c1);
		Interpret i1 = new Interpret(150,"Hans", "Hans");
		dbm.insertInterpret(con, i1);
		Song so1 = new Song(900, "Song1", 3.16, i1, c1);
		dbm.insertSong(con, so1);
		Song so2 = dbm.getSongById(con, 900);
		
		String s1 = so1.toString();
		String s2 = so2.toString();
		
		assertEquals(s1,s2);
		
		dbm.deleteSongByID(con, 900);
		dbm.deleteCDByID(con, 100);
		dbm.deleteInterpretByID(con, 150);
	}
	

}
