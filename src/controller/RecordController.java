package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import Utility.ConnectionClass;
import model.HealthSystemUser;
import model.Observation;

public class RecordController {
	
	public int insertRecord( int id,HealthSystemUser hs,HealthSystemUser pt, Observation oid, int value, Date obsTime, Date recTime)
	{
        PreparedStatement stmt = null;
        Connection conn = null;
        int result = -1;
		try
		{
			
		conn = ConnectionClass.connect();
		
		String query = "insert into RECORD values(?, ?, ?,?,?,?,?)";

	    stmt = conn.prepareStatement(query); // create a statement
	    stmt.setInt(1, id); // set input parameter 1
	    stmt.setString(2, hs.getId()); // set input parameter 2
	    stmt.setString(3, pt.getId()); // set input parameter 3
	    stmt.setInt(4, oid.getId());
	    stmt.setInt(5, value); // set input parameter 3
	    stmt.setDate(6, obsTime );
	    stmt.setDate(7, recTime);
	    
	    result = stmt.executeUpdate(); // execute insert statement
			
        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		finally {
            ConnectionClass.close(stmt);
            ConnectionClass.close(conn);
        }
		return result;
	}

}
