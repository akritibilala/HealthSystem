package Utility;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionClass {
	static final String jdbcURL 
	= "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";

    public static void main(String[] args) {
        try {

            // Load the driver. This creates an instance of the driver
	    // and calls the registerDriver method to make Oracle Thin
	    // driver available to clients.

            Class.forName("oracle.jdbc.driver.OracleDriver");

	    String user = "gmkhande";	// For example, "jsmith"
	    String passwd = "200122949";	// Your 9 digit student ID number


          	Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {

		// Get a connection from the first driver in the
		// DriverManager list that recognizes the URL jdbcURL

		conn = DriverManager.getConnection(jdbcURL, user, passwd);

		// Create a statement object that will be sending your
		// SQL statements to the DBMS

		stmt = conn.createStatement();

		// Populate the COFFEES table

		stmt.executeUpdate("INSERT INTO HEALTHSYSTEMUSER " +
			   "VALUES ('6', 'Tanmay', 'Delhi', 'tgoel@ncsu.edu', 'MALE', TO_DATE('1991-01-29 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'testing')");

		rs = stmt.executeQuery("SELECT NAME, ADDRESS FROM HEALTHSYSTEMUSER");

		// Now rs contains the rows of coffees and prices from
		// the COFFEES table. To access the data, use the method
		// NEXT to access all rows in rs, one row at a time

		while (rs.next()) {
		    String s = rs.getString("NAME");
		    float n = rs.getFloat("ADDRESS");
		    System.out.println(s + "   " + n);
		}

            } finally {
                close(rs);
                close(stmt);
                close(conn);
            }
        } catch(Throwable oops) {
            oops.printStackTrace();
        }
    }

    static void close(Connection conn) {
        if(conn != null) {
            try { conn.close(); } catch(Throwable whatever) {}
        }
    }

    static void close(Statement st) {
        if(st != null) {
            try { st.close(); } catch(Throwable whatever) {}
        }
    }

    static void close(ResultSet rs) {
        if(rs != null) {
            try { rs.close(); } catch(Throwable whatever) {}
        }
    }

}
