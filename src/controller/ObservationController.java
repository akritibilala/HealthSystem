package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Disease;
import model.Observation;
import utils.ConnectionClass;

public class ObservationController {
	
	public List<Observation> getObservationList()
	{
		List<Observation> observationList = new ArrayList<>();
		
        Statement stmt = null;
        ResultSet rs1 = null;
        Connection conn = null;
		try
		{
			
		conn = ConnectionClass.connect();
		
		// Create a statement object that will be sending your
		// SQL statements to the DBMS
		stmt = conn.createStatement();

		//Special Recommendation
			rs1 = stmt.executeQuery("SELECT OBSERVATION_ID,OBSERVATION_TYPE,MEASURE,METRIC,DESCRIPTION "
				+ "FROM OBSERVATION");
			
			while (rs1.next()) {
				//Add observation
				Observation observation = new Observation();
				observation.setDescription(rs1.getString("DESCRIPTION"));
				observation.setId(Integer.parseInt(rs1.getString("OBSERVATION_ID")));
				observation.setMeasure(rs1.getString("MEASURE"));
				observation.setMetric(rs1.getString("METRIC"));
				observation.setType(rs1.getString("OBSERVATION_TYPE"));
				observationList.add(observation);
			}

        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		finally {
            ConnectionClass.close(rs1);
            ConnectionClass.close(stmt);
            ConnectionClass.close(conn);
        }
        return observationList;
	}

}
