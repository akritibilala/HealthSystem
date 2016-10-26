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
import model.Disease;
import model.HealthSupporter;
import model.HealthSystemUser;
import model.Observation;
import model.Recommendation;

public class DiseaseController {
	
	public List<Disease> getDiseaseList()
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
				+ "FROM DISEASE d");
			
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
	
	public int deleteDiagnoses(HealthSystemUser user, Disease diseaseToRemove) {
		
        Statement stmt = null;
        ResultSet rs1 = null;
        Connection conn = null;
		try
		{
			
		conn = ConnectionClass.connect();
		
		// Create a statement object that will be sending your
		// SQL statements to the DBMS
		stmt = conn.createStatement();

		//Disease
			int count = stmt.executeUpdate("DELETE "
				+ "FROM SICK_PATIENT "
				+ "WHERE SICK_PATIENT_ID='"+user.getId()+"' "
				+ "AND DISEASE_ID="+diseaseToRemove.getDiseaseId());
			
			return count;
        } catch(Throwable oops) {
            oops.printStackTrace();
        }
		finally {
            ConnectionClass.close(rs1);
            ConnectionClass.close(stmt);
            ConnectionClass.close(conn);
        }
        return -1;
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
	
	/**
	 * This method will add a diagnosis to a patient.
	 * It will also change the status of the user to a Sick Patient.
	 * @param user
	 * @param disease
	 * @param date
	 * @return
	 * @throws Exception 
	 */
	public int setDiagnoses(HealthSystemUser user,Disease disease,Date date) throws Exception
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
	    
        } catch(SQLException oops) {
        	oops.printStackTrace();
            throw new Exception("Error in adding diagnosis to patient : "+user.getName());
        }
		catch(Throwable t)
		{
			t.printStackTrace();
		}
		finally {
            ConnectionClass.close(stmt);
            ConnectionClass.close(conn);
        }
		return result;
	}
	
}
