package Utility;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionClass {
	static final String jdbcURL 
	= "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";
	
	public static Connection connect()
	{
		try {

            // Load the driver. This creates an instance of the driver
	    // and calls the registerDriver method to make Oracle Thin
	    // driver available to clients.

            Class.forName("oracle.jdbc.driver.OracleDriver");

	    String user = "gmkhande";	// For example, "jsmith"
	    String passwd = "200122949";	// Your 9 digit student ID number


          	Connection conn = null;

		// Get a connection from the first driver in the
		// DriverManager list that recognizes the URL jdbcURL

            	return DriverManager.getConnection(jdbcURL, user, passwd);

        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		return null;
	}

    public static void close(Connection conn) {
        if(conn != null) {
            try { conn.close(); } catch(Throwable whatever) {}
        }
    }

    public static void close(Statement st) {
        if(st != null) {
            try { st.close(); } catch(Throwable whatever) {}
        }
    }

    public static void close(ResultSet rs) {
        if(rs != null) {
            try { rs.close(); } catch(Throwable whatever) {}
        }
    }

}
