package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import model.HealthSystemUser;
import model.Observation;
import utils.ConnectionClass;

public class RecordController {
	
	public int insertRecord(HealthSystemUser hs,HealthSystemUser pt, Observation observation, String value, Date obsTime, Date recTime)
	{
        PreparedStatement stmt = null;
        Connection conn = null;
        int result = -1;
		try
		{
			
		conn = ConnectionClass.connect();
		
		String query = "insert into RECORD(PATIENT_ID,HEALTHSUPPORTER_ID,OBS_ID,VALUE,OBS_DATE_TIME,REC_DATE_TIME) values(?, ?, ?,?,?,?)";

	    stmt = conn.prepareStatement(query); // create a statement
	    stmt.setString(1, pt.getId()); // set input parameter 3
	    stmt.setString(2, hs.getId()); // set input parameter 2
	    stmt.setInt(3, observation.getId());
	    stmt.setString(4, value); // set input parameter 3
	    stmt.setDate(5, obsTime );
	    stmt.setDate(6, recTime);
	    
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
	
	public int insertRecord(HealthSystemUser pt, Observation observation, String value, Date obsTime, Date recTime)
	{
        PreparedStatement stmt = null;
        Connection conn = null;
        int result = -1;
		try
		{
			
		conn = ConnectionClass.connect();
		
		String query = "insert into RECORD(PATIENT_ID,OBS_ID,VALUE,OBS_DATE_TIME,REC_DATE_TIME) values(?, ?, ?,?,?)";

	    stmt = conn.prepareStatement(query); // create a statement
	    stmt.setString(1, pt.getId()); // set input parameter 3
	    stmt.setInt(2, observation.getId());
	    stmt.setString(3, value); // set input parameter 3
	    stmt.setDate(4, obsTime );
	    stmt.setDate(5, recTime);
	    
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
