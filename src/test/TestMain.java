package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import controller.AlertController;
import controller.UserController;
import model.Alert;
import model.Disease;
import model.HealthSupporter;
import model.HealthSystemUser;
import utils.ConnectionClass;

public class TestMain {
	
	public static void main(String[] args) throws ParseException {
		UserController user = new UserController();
//		HealthSystemUser u = new HealthSystemUser();
//		u.setId("P1");
//		AlertController ac = new AlertController();
//		ac.getAlertPatientInfo(u);
//		HealthSystemUser u4 = new HealthSystemUser();
//		u4.setId("P3");
//		HealthSupporter u1 = new HealthSupporter();
//		u1.setId("P4");
//		Map<String,Recommendation> rec = user.getRecommendations(u);
//		printMap(rec);
//		System.out.println(user.getDiagnoses(u));
//		Disease disease = new Disease();
//		disease.setDiseaseId(1);
//		disease.setName("HIV");
//		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
////		user.setDiagnoses(u, disease, date);
////		System.out.println(user.login("P1", "password"));
//		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//        Date parsed = format.parse("20161021");
//        java.sql.Date sql = new java.sql.Date(parsed.getTime());
////		user.updateUser("P5", "Omkara", "Mumbai", "MALE", sql, "password");
//		
//		user.addAUserAsHealthSupporter(u4, u1, "PRIMARY", sql);
		
//		HealthSystemUser u = new HealthSystemUser();
//		HealthSystemUser v = new HealthSystemUser();
//		Observation o=new Observation();
//		u.setId("P4");
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
////        Date parsed = format.parse("20110210");
//        Date temp=sdf.parse("2016-10-17 00:00:00");
////        u.setId("P3");
////        v.setId("P2");
////        o.setId(5);
////        java.sql.Date sql = new java.sql.Date(parsed.getTime());
//        java.sql.Date sql_temp = new java.sql.Date(temp.getTime());
//        
//        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//        System.out.println(getDateDiff(date, sql_temp, TimeUnit.DAYS));
//		//user.insertUser("P5", "Omkar", "Mumbai", "MALE", sql, "password");
//        RecordController record = new RecordController();
//		record.insertRecord(2,u,v, o, 195, sql_temp,sql_temp);
		
//		System.out.println(user.getHealthSupporters(u));
//		HealthSystemUser us1 = new HealthSystemUser();
//		HealthSupporter u2 = new HealthSupporter();
//		u2.setId("P2");
//		
//		user.getHealthSupportersAuthorizations(u2);
//		
//		try {
////			user.setDiagnoses(u, disease, date);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		HealthSystemUser u = new HealthSystemUser();
		u.setId("P1");
		AlertController ac = new AlertController();
		ac.generateAlert(u);
	}
	
	public static void printMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	/**
	 * Get a diff between two dates
	 * @param date1 the oldest date
	 * @param date2 the newest date
	 * @param timeUnit the unit in which you want the diff
	 * @return the diff value, in the provided unit
	 */
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date1.getTime() - date2.getTime();
	    int day = (int)diffInMillies/(24*60*60*1000);
	    return timeUnit.convert(diffInMillies,timeUnit);
	}
	
//	void test()
//	{
//		//Outside the limit
//		Double upperLimit = recomendation.getUpperLimit();
//		Double lowerLimit = recomendation.getLowerLimit();
//		Integer alertObservationThresold = alertPatientInfo.getAlertObservationThreshold();
//		Integer alertPercentageThreshold = alertPatientInfo.getAlertPercentageThreshold();
//		if(upperLimit!=null&&lowerLimit!=null&&alertObservationThresold!=null&&alertPercentageThreshold!=null)
//		{
//			Connection conn = null;
//			Statement stmt = null;
//			ResultSet rs = null;
//			try
//			{
//				conn = ConnectionClass.connect();
//				String query = "Select VALUE from (Select DISTINCT VALUE from Record where patient_id='"+user.getId()+"' AND OBS_ID="+observation.getId()+" AND "+alertObservationThresold+" ORDER BY OBS_DATE_TIME DESC) WHERE ROWNUM <= "+alertObservationThresold;
//				stmt = conn.createStatement(); 
//				rs=stmt.executeQuery(query);
//				int count = 0;
//				int totalCount = 0;
//				while(rs.next())
//				{
//					String val = rs.getString("VALUE");
//					int value = Integer.parseInt(val);
//					if(value<lowerLimit || value>upperLimit)
//						count ++;
//					totalCount++;
//				}
//				if(totalCount == alertObservationThresold)
//				{
//					Double percentage = (double) count*100/totalCount;
//					if(percentage>alertPercentageThreshold)
//					{
//						Alert alert = new Alert();
//						alert.setAlertMessage(percentage+"% number of recordings are outside the limit");
//						java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//						alert.setDate(date);
//						alert.setObsType(observation);
//						alert.setPatient(user);
//						alert.setStatus("ACTIVE");
//						alert.setType("outside-the-limit");
//					}
//				}
//			}
//			catch(Exception e1)
//			{
//			e1.printStackTrace();
//			}
//			finally
//			{
//				ConnectionClass.close(conn);
//				ConnectionClass.close(stmt);
//				ConnectionClass.close(rs);
//			}
//			
//		}
//	}

}
