package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Utility.ConnectionClass;

public class UserDao {
	
	public void getRecommendations()
	{
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
		try
		{
			
		conn = ConnectionClass.connect();
		
		// Create a statement object that will be sending your
		// SQL statements to the DBMS

		stmt = conn.createStatement();

		rs = stmt.executeQuery("SELECT o.OBSERVATION_TYPE, s.UPPER_LIMIT,s.LOWER_LIMIT, s.FREQUENCY, s.OBS_ID FROM SPECIAL_RECOMMENDATION s,OBSERVATION o "
				+ "WHERE s.PATIENT_ID='P2' "
				+ "AND s.OBS_ID = o.OBSERVATION_ID");

		// Now rs contains the rows of coffees and prices from
		// the COFFEES table. To access the data, use the method
		// NEXT to access all rows in rs, one row at a time

		while (rs.next()) {
			String s = rs.getString("OBSERVATION_TYPE");
			String s1 = rs.getString("FREQUENCY");
		    String s2 = rs.getString("UPPER_LIMIT");
		    String n = rs.getString("LOWER_LIMIT");
		    System.out.println(s + "   " + s1 + "   " + s2+ " "+ n);
		}

        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		finally {
            ConnectionClass.close(rs);
            ConnectionClass.close(stmt);
            ConnectionClass.close(conn);
        }
        
	}
	
}
