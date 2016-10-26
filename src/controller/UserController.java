package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utility.ConnectionClass;
import model.Authorization;
import model.HealthSupporter;
import model.HealthSystemUser;
import model.Observation;
import model.Recommendation;

public class UserController {
	
	public Map<Observation,Recommendation> getRecommendations(HealthSystemUser user)
	{
        Statement stmt = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        Connection conn = null;
        Map<Observation,Recommendation> obsMap = new HashMap<Observation,Recommendation>();
		try
		{
			
		conn = ConnectionClass.connect();
		
		// Create a statement object that will be sending your
		// SQL statements to the DBMS
		stmt = conn.createStatement();

		//Special Recommendation
			rs1 = stmt.executeQuery("SELECT o.OBSERVATION_ID, o.DESCRIPTION, o.METRIC, o.MEASURE, o.OBSERVATION_TYPE,s.UPPER_LIMIT,s.LOWER_LIMIT, s.FREQUENCY,s.TEXT FROM SPECIAL_RECOMMENDATION s,OBSERVATION o "
				+ "WHERE s.PATIENT_ID='"+user.getId()+"' "
				+ "AND s.OBS_ID = o.OBSERVATION_ID");
			
			while (rs1.next()) {
				//Add observation
				Observation obs = new Observation();
				obs.setId(rs1.getInt("OBSERVATION_ID"));
				obs.setDescription(rs1.getString("DESCRIPTION"));
				obs.setMeasure(rs1.getString("MEASURE"));
				obs.setMetric(rs1.getString("METRIC"));
				obs.setType(rs1.getString("OBSERVATION_TYPE"));
				
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
				obsMap.put(obs, recommendation);
			}
		
			//Disease Recommendation
			rs2 = stmt.executeQuery("SELECT o.OBSERVATION_ID, o.DESCRIPTION, o.METRIC, o.MEASURE, o.OBSERVATION_TYPE, s.UPPER_LIMIT,s.LOWER_LIMIT, s.FREQUENCY, s.TEXT "
				+ "FROM DISEASE_RECOMMENDATION s,OBSERVATION o "
				+ "WHERE s.DISEASE_ID IN (SELECT DISEASE_ID from SICK_PATIENT where SICK_PATIENT_ID = '"+user.getId()+"')"
				+ "AND s.OBS_ID = o.OBSERVATION_ID");
		
			while (rs2.next()) {
				//Add observation
				Observation obs = new Observation();
				obs.setId(rs2.getInt("OBSERVATION_ID"));
				obs.setDescription(rs2.getString("DESCRIPTION"));
				obs.setMeasure(rs2.getString("MEASURE"));
				obs.setMetric(rs2.getString("METRIC"));
				obs.setType(rs2.getString("OBSERVATION_TYPE"));
				
				if(!obsMap.containsKey(obs))
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
					obsMap.put(obs, recommendation);	
				}
			}
		
			//General Recommendation
			rs3 = stmt.executeQuery("SELECT o.OBSERVATION_ID, o.DESCRIPTION, o.METRIC, o.MEASURE, o.OBSERVATION_TYPE, s.UPPER_LIMIT,s.LOWER_LIMIT, s.FREQUENCY, s.TEXT "
				+ "FROM GENERAL_RECOMMENDATION s,OBSERVATION o "
				+ "WHERE s.OBS_ID = o.OBSERVATION_ID");
		
			while (rs3.next()) {
				//Add observation
				Observation obs = new Observation();
				obs.setId(rs3.getInt("OBSERVATION_ID"));
				obs.setDescription(rs3.getString("DESCRIPTION"));
				obs.setMeasure(rs3.getString("MEASURE"));
				obs.setMetric(rs3.getString("METRIC"));
				obs.setType(rs3.getString("OBSERVATION_TYPE"));
				//Add recommendation
				if(!obsMap.containsKey(obs))
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
					obsMap.put(obs, recommendation);	
				}
			}

        } catch(Throwable oops) {
            oops.printStackTrace();
            {
	            	Observation obs = new Observation();
	            	obs.setId(1);
	            	obs.setDescription(("Sample DESCRIPTION"));
	            	obs.setMeasure(("Sample MEASURE"));
	            	obs.setMetric(("Sample METRIC"));
	            	obs.setType(("Sample OBSERVATION_TYPE"));
	            	//Add recommendation
	            	if(!obsMap.containsKey(obs))
	            	{
	            		//Only add recommendation if it does not added by special recommendation
	            		Recommendation recommendation = new Recommendation();
	            		String upperLimit = "75";
	            		if(upperLimit!=null)
	            			recommendation.setUpperLimit(Double.parseDouble(upperLimit));
	            		String lowerLimit = "30";
	            		if(lowerLimit!=null)
	            			recommendation.setLowerLimit(Double.parseDouble(lowerLimit));
	            		String frequency = "7";
	            		if(frequency!=null)
	            			recommendation.setFrequency(Integer.parseInt(frequency));
	            		String text = "abcd";
	            		if(text!=null)
	            			recommendation.setText((text));
	            		obsMap.put(obs, recommendation);	
	            	}
            }
            {
            	Observation obs = new Observation();
            	obs.setId(2);
            	obs.setDescription(("Sample DESCRIPTION 2"));
            	obs.setMeasure(("Sample MEASURE 2"));
            	obs.setMetric(("Sample METRIC 2"));
            	obs.setType(("Sample OBSERVATION_TYPE 2"));
            	//Add recommendation
            	if(!obsMap.containsKey(obs))
            	{
            		//Only add recommendation if it does not added by special recommendation
            		Recommendation recommendation = new Recommendation();
            		String upperLimit = "30";
            		if(upperLimit!=null)
            			recommendation.setUpperLimit(Double.parseDouble(upperLimit));
            		String lowerLimit = "10";
            		if(lowerLimit!=null)
            			recommendation.setLowerLimit(Double.parseDouble(lowerLimit));
            		String frequency = "8";
            		if(frequency!=null)
            			recommendation.setFrequency(Integer.parseInt(frequency));
            		String text = null;
            		if(text!=null)
            			recommendation.setText((text));
            		obsMap.put(obs, recommendation);	
            	}
        }
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
	
	
	public HealthSystemUser login(String uid,String password)
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

		String sql = "SELECT ID,NAME,DOB,GENDER,ADDRESS,TYPE "
				+ "FROM HEALTHSYSTEM_USER "
				+ "WHERE ID='"+uid+"' "
				+ "AND PASSWORD='"+password+"'";
			//Login
			rs1 = stmt.executeQuery(sql);
			
			if(rs1.next()) {
				//Add user details
				HealthSystemUser user = new HealthSystemUser(rs1.getString("ID"),rs1.getDate("DOB"),rs1.getString("GENDER"),
																rs1.getString("ADDRESS"),rs1.getString("NAME"),rs1.getString("TYPE"));
				return user;
			}

        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		finally {
            ConnectionClass.close(rs1);
            ConnectionClass.close(stmt);
            ConnectionClass.close(conn);
        }
        return null;
	}
	
	public int insertUser(String id,String name,String address, String gender,Date date, String password,String type)
	{
        PreparedStatement stmt = null;
        Connection conn = null;
        int result = -1;
		try
		{
			
		conn = ConnectionClass.connect();
		
		String query = "insert into HEALTHSYSTEM_USER values(?, ?, ?,?,?,?,?)";

	    stmt = conn.prepareStatement(query); // create a statement
	    stmt.setString(1, id); // set input parameter 1
	    stmt.setString(2, name); // set input parameter 2
	    stmt.setString(3, address); // set input parameter 3
	    stmt.setString(4, gender); // set input parameter 3
	    stmt.setString(6, password);
	    stmt.setDate(5, date);
	    stmt.setString(7, type);
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
	
	public int updateUser(String id,String name,String address, String gender,Date date, String password)
	{
        PreparedStatement stmt = null;
        Connection conn = null;
        int result = -1;
		try
		{
			
		conn = ConnectionClass.connect();
		
		PreparedStatement update = conn.prepareStatement
			    ("UPDATE HEALTHSYSTEM_USER SET NAME = ?, ADDRESS = ?, GENDER = ?, DOB = ?, PASSWORD = ? WHERE id = ?");

		update.setString(1, name);
		update.setString(2, address);
		update.setString(3, gender);
		update.setDate(4, date);
		update.setString(5, password);
		update.setString(6, id);
		
		result = update.executeUpdate();
			
        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		finally {
            ConnectionClass.close(stmt);
            ConnectionClass.close(conn);
        }
		return result;
	}
	

	/**
	 * This method will add a health supporter for the given user.
	 * It will also add the authorization date and type of the health supporter for the given user.
	 * @param user Patient for whom a health supporter is to be added.
	 * @param supporter Health Supporter which is to be added.
	 * @param type Type of the health supporter
	 * @param authorizationDate Authorization Date
	 * @return
	 */
	public int addAUserAsHealthSupporter(HealthSystemUser user,HealthSupporter supporter, String type, Date authorizationDate)
	{
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        Connection conn = null;
        int result = -1;
		try
		{
			
		conn = ConnectionClass.connect();
		
		String query1 = "insert into HEALTH_SUPPORTER values(?)";

	    stmt1 = conn.prepareStatement(query1); // create a statement
	    stmt1.setString(1, supporter.getId()); // set input parameter 1
	    result = stmt1.executeUpdate(); // execute insert statement
	    
		String query2 = "insert into AUTHORIZATION values(?,?,?,?)";

	    stmt2 = conn.prepareStatement(query2); // create a statement
	    stmt2.setString(1, user.getId()); // set input parameter 1
	    stmt2.setString(2, supporter.getId()); // set input parameter 1
	    stmt2.setString(3, type); // set input parameter 1
	    stmt2.setDate(4, authorizationDate); // set input parameter 1
	    result = stmt2.executeUpdate(); // execute insert statement
			
        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		finally {
            ConnectionClass.close(stmt1);
            ConnectionClass.close(stmt2);
            ConnectionClass.close(conn);
        }
		return result;
	}
	
	/**
	 * This method will add a health supporter for the given user.
	 * It will also add the authorization date and type of the health supporter for the given user.
	 * @param user Patient for whom a health supporter is to be added.
	 * @param supporter Health Supporter which is to be added.
	 * @param type Type of the health supporter
	 * @param authorizationDate Authorization Date
	 * @return
	 */
	public int addExistingUserAsHealthSupporter(HealthSystemUser user,HealthSupporter supporter, String type, Date authorizationDate)
	{
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        Connection conn = null;
        int result = -1;
		try
		{
			
		conn = ConnectionClass.connect();
		
		String query2 = "insert into AUTHORIZATION(PATIENT_ID,HEALTH_SUPPORTER_ID,HEALTH_SUPPORTER_TYPE,AUTHORIZATION_DATE) values(?,?,?,?)";

	    stmt2 = conn.prepareStatement(query2); // create a statement
	    stmt2.setString(1, user.getId()); // set input parameter 1
	    stmt2.setString(2, supporter.getId()); // set input parameter 1
	    stmt2.setString(3, type); // set input parameter 1
	    stmt2.setDate(4, authorizationDate); // set input parameter 1
	    result = stmt2.executeUpdate(); // execute insert statement
			
        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		finally {
            ConnectionClass.close(stmt1);
            ConnectionClass.close(stmt2);
            ConnectionClass.close(conn);
        }
		return result;
	}
	
	public List<Authorization> getHealthSupportersAuthorizations(HealthSystemUser user)
	{
		List<Authorization> healthSupporterList = new ArrayList<>();
		
        Statement stmt = null;
        ResultSet rs1 = null;
        Connection conn = null;
		try
		{
			
		conn = ConnectionClass.connect();
		
		// Create a statement object that will be sending your
		// SQL statements to the DBMS
		stmt = conn.createStatement();

		//HealthSupporters
			rs1 = stmt.executeQuery("SELECT h.ID,h.NAME,h.ADDRESS,h.GENDER,h.DOB,a.AUTHORIZATION_DATE,a.HEALTH_SUPPORTER_TYPE "
				+ "FROM AUTHORIZATION a,HEALTHSYSTEM_USER h "
				+ "WHERE a.PATIENT_ID='"+user.getId()+"' "
				+ "AND a.HEALTH_SUPPORTER_ID = h.ID");
			
			while (rs1.next()) {
				//Add health supporter
				HealthSupporter supporter = new HealthSupporter();
				String id = rs1.getString("ID");
				if(id!=null)
					supporter.setId(id);
				String name = rs1.getString("NAME");
				if(name!=null)
					supporter.setName(name);
				String address = rs1.getString("ADDRESS");
				if(address!=null)
					supporter.setAddress(address);
				String gender = rs1.getString("GENDER");
				if(gender!=null)
					supporter.setGender(gender);
				Date date = rs1.getDate("DOB");
				if(date!=null)
					supporter.setDateOfBirth(date);
				//Add authorization
				Authorization auth = new Authorization();
				auth.setHealthSupporter(supporter);
				auth.setPatient(user);
				Date authDate = rs1.getDate("AUTHORIZATION_DATE");
				if(authDate!=null)
					auth.setAuthorizationDate(authDate);
				String authType = rs1.getString("HEALTH_SUPPORTER_TYPE");
				if(authType!=null)
					auth.setHealthSupporterType(authType);
				
				healthSupporterList.add(auth);
			}

        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		finally {
            ConnectionClass.close(rs1);
            ConnectionClass.close(stmt);
            ConnectionClass.close(conn);
        }
        return healthSupporterList;
	}
	
	public List<Authorization> getPatientsUnderHealthSupporter(HealthSupporter supporter)
	{
		List<Authorization> patientList = new ArrayList<>();
		
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
			rs1 = stmt.executeQuery("SELECT h.ID,h.NAME,h.ADDRESS,h.GENDER,h.DOB,a.AUTHORIZATION_DATE,a.HEALTH_SUPPORTER_TYPE "
				+ "FROM AUTHORIZATION a,HEALTHSYSTEM_USER h "
				+ "WHERE a.HEALTH_SUPPORTER_ID='"+supporter.getId()+"' "
				+ "AND a.PATIENT_ID = h.ID");
			
			while (rs1.next()) {
				//Add health supporter
				HealthSystemUser patient = new HealthSystemUser();
				String id = rs1.getString("ID");
				if(id!=null)
					patient.setId(id);
				String name = rs1.getString("NAME");
				if(name!=null)
					patient.setName(name);
				String address = rs1.getString("ADDRESS");
				if(address!=null)
					patient.setAddress(address);
				String gender = rs1.getString("GENDER");
				if(gender!=null)
					patient.setGender(gender);
				Date date = rs1.getDate("DOB");
				if(date!=null)
					patient.setDateOfBirth(date);
				//Add authorization
				Authorization auth = new Authorization();
				auth.setHealthSupporter(supporter);
				auth.setPatient(patient);
				Date authDate = rs1.getDate("AUTHORIZATION_DATE");
				if(authDate!=null)
					auth.setAuthorizationDate(authDate);
				String authType = rs1.getString("HEALTH_SUPPORTER_TYPE");
				if(authType!=null)
					auth.setHealthSupporterType(authType);
				
				patientList.add(auth);
			}

        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		finally {
            ConnectionClass.close(rs1);
            ConnectionClass.close(stmt);
            ConnectionClass.close(conn);
        }
        return patientList;
	}
	
}
