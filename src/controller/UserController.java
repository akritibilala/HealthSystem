package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utility.ConnectionClass;
import model.Disease;
import model.HealthSystemUser;
import model.Recommendation;

public class UserController {
	
	public Map<String,Recommendation> getRecommendations(HealthSystemUser user)
	{
        Statement stmt = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        Connection conn = null;
        Map<String,Recommendation> obsMap = new HashMap<String,Recommendation>();
		try
		{
			
		conn = ConnectionClass.connect();
		
		// Create a statement object that will be sending your
		// SQL statements to the DBMS
		stmt = conn.createStatement();

		//Special Recommendation
			rs1 = stmt.executeQuery("SELECT o.OBSERVATION_TYPE,s.UPPER_LIMIT,s.LOWER_LIMIT, s.FREQUENCY,s.TEXT FROM SPECIAL_RECOMMENDATION s,OBSERVATION o "
				+ "WHERE s.PATIENT_ID='"+user.getId()+"' "
				+ "AND s.OBS_ID = o.OBSERVATION_ID");
			
			while (rs1.next()) {
				//Add observation
				String observation = rs1.getString("OBSERVATION_TYPE");
				//Add recommendation
				Recommendation recommendation = new Recommendation();
				String upperLimit = rs1.getString("UPPER_LIMIT");
				if(upperLimit!=null)
				recommendation.setUpperLimit(Double.parseDouble(upperLimit));
				String lowerLimit = rs1.getString("LOWER_LIMIT");
				if(lowerLimit!=null)
				recommendation.setLowerLimit(Double.parseDouble(lowerLimit));
				String frequency = rs1.getString("FREQUENCY");
				if(frequency!=null)
				recommendation.setFrequency(Integer.parseInt(frequency));
				String text = rs1.getString("TEXT");
				if(text!=null)
				recommendation.setText((text));
				obsMap.put(observation, recommendation);
			}
		
			//Disease Recommendation
			rs2 = stmt.executeQuery("SELECT o.OBSERVATION_TYPE, s.UPPER_LIMIT,s.LOWER_LIMIT, s.FREQUENCY, s.TEXT "
				+ "FROM DISEASE_RECOMMENDATION s,OBSERVATION o "
				+ "WHERE s.DISEASE_ID IN (SELECT DISEASE_ID from SICK_PATIENT where SICK_PATIENT_ID = '"+user.getId()+"')"
				+ "AND s.OBS_ID = o.OBSERVATION_ID");
		
			while (rs2.next()) {
				//Add observation
				String observation = rs2.getString("OBSERVATION_TYPE");
				//Add recommendation
				if(!obsMap.containsKey(observation))
				{
					//Only add recommendation if it does not added by special recommendation
					Recommendation recommendation = new Recommendation();
					String upperLimit = rs2.getString("UPPER_LIMIT");
					if(upperLimit!=null)
					recommendation.setUpperLimit(Double.parseDouble(upperLimit));
					String lowerLimit = rs2.getString("LOWER_LIMIT");
					if(lowerLimit!=null)
					recommendation.setLowerLimit(Double.parseDouble(lowerLimit));
					String frequency = rs2.getString("FREQUENCY");
					if(frequency!=null)
					recommendation.setFrequency(Integer.parseInt(frequency));
					String text = rs2.getString("TEXT");
					if(text!=null)
					recommendation.setText((text));
					obsMap.put(observation, recommendation);	
				}
			}
		
			//GEneral Recommendation
			rs3 = stmt.executeQuery("SELECT o.OBSERVATION_TYPE, s.UPPER_LIMIT,s.LOWER_LIMIT, s.FREQUENCY, s.TEXT "
				+ "FROM GENERAL_RECOMMENDATION s,OBSERVATION o "
				+ "WHERE s.OBS_ID = o.OBSERVATION_ID");
		
			while (rs3.next()) {
				//Add observation
				String observation = rs3.getString("OBSERVATION_TYPE");
				//Add recommendation
				if(!obsMap.containsKey(observation))
				{
					//Only add recommendation if it does not added by special recommendation
					Recommendation recommendation = new Recommendation();
					String upperLimit = rs3.getString("UPPER_LIMIT");
					if(upperLimit!=null)
					recommendation.setUpperLimit(Double.parseDouble(upperLimit));
					String lowerLimit = rs3.getString("LOWER_LIMIT");
					if(lowerLimit!=null)
					recommendation.setLowerLimit(Double.parseDouble(lowerLimit));
					String frequency = rs3.getString("FREQUENCY");
					if(frequency!=null)
					recommendation.setFrequency(Integer.parseInt(frequency));
					String text = rs3.getString("TEXT");
					if(text!=null)
					recommendation.setText((text));
					obsMap.put(observation, recommendation);	
				}
			}

        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		finally {
            ConnectionClass.close(rs1);
            ConnectionClass.close(rs2);
            ConnectionClass.close(rs3);
            ConnectionClass.close(stmt);
            ConnectionClass.close(conn);
        }
        return obsMap;
	}
	
	public List<Disease> getDiagnoses(HealthSystemUser user)
	{
		List<Disease> diseaseList = new ArrayList<>();
		
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
			rs1 = stmt.executeQuery("SELECT d.NAME,d.DISEASE_ID "
				+ "FROM SICK_PATIENT s,DISEASE d "
				+ "WHERE s.SICK_PATIENT_ID='"+user.getId()+"' "
				+ "AND d.DISEASE_ID = s.DISEASE_ID");
			
			while (rs1.next()) {
				//Add disease
				Disease disease = new Disease();
				String name = rs1.getString("NAME");
				if(name!=null)
					disease.setName(name);
				Integer id = rs1.getInt("DISEASE_ID");
				if(id!=null)
					disease.setDiseaseId(id);
				diseaseList.add(disease);
			}

        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		finally {
            ConnectionClass.close(rs1);
            ConnectionClass.close(stmt);
            ConnectionClass.close(conn);
        }
        return diseaseList;
	}
	
	public int setDiagnoses(HealthSystemUser user,Disease disease,Date date)
	{
        PreparedStatement stmt = null;
        Connection conn = null;
        int result = -1;
		try
		{
			
		conn = ConnectionClass.connect();
		
		String query = "insert into SICK_PATIENT(SICK_PATIENT_ID, DISEASE_ID, SINCE_DATE) values(?, ?, ?)";

	    stmt = conn.prepareStatement(query); // create a statement
	    stmt.setString(1, user.getId()); // set input parameter 1
	    stmt.setInt(2, disease.getDiseaseId()); // set input parameter 2
	    stmt.setDate(3, date); // set input parameter 3
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
	
	public boolean login(String uid,String password)
	{
        Statement stmt = null;
        ResultSet rs1 = null;
        Connection conn = null;
		try
		{
			
		conn = ConnectionClass.connect();
		
		// Create a statement object that will be sending your
		// SQL statements to the DBMS
		stmt = conn.createStatement();

		String sql = "SELECT ID "
				+ "FROM HEALTHSYSTEM_USER "
				+ "WHERE ID='"+uid+"' "
				+ "AND PASSWORD='"+password+"'";
			//Login
			rs1 = stmt.executeQuery(sql);
			
			if(rs1.next()) {
				return true;
			}

        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		finally {
            ConnectionClass.close(rs1);
            ConnectionClass.close(stmt);
            ConnectionClass.close(conn);
        }
        return false;
	}
	
	public int insertUser(String id,String name,String address, String gender,Date date, String password)
	{
        PreparedStatement stmt = null;
        Connection conn = null;
        int result = -1;
		try
		{
			
		conn = ConnectionClass.connect();
		
		String query = "insert into HEALTHSYSTEM_USER values(?, ?, ?,?,?,?)";

	    stmt = conn.prepareStatement(query); // create a statement
	    stmt.setString(1, id); // set input parameter 1
	    stmt.setString(2, name); // set input parameter 2
	    stmt.setString(3, address); // set input parameter 3
	    stmt.setString(4, gender); // set input parameter 3
	    stmt.setString(6, password);
	    stmt.setDate(5, date);
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
