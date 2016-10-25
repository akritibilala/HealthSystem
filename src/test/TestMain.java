package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import controller.UserController;
import model.Disease;
import model.HealthSystemUser;

public class TestMain {
	
	public static void main(String[] args) throws ParseException {
		UserController user = new UserController();
		HealthSystemUser u = new HealthSystemUser();
		u.setId("P1");
//		HealthSystemUser u4 = new HealthSystemUser();
//		u4.setId("P3");
//		HealthSupporter u1 = new HealthSupporter();
//		u1.setId("P4");
//		Map<String,Recommendation> rec = user.getRecommendations(u);
//		printMap(rec);
//		System.out.println(user.getDiagnoses(u));
		Disease disease = new Disease();
		disease.setDiseaseId(1);
		disease.setName("HIV");
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//		user.setDiagnoses(u, disease, date);
//		System.out.println(user.login("P1", "password"));
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//        Date parsed = format.parse("20161021");
//        java.sql.Date sql = new java.sql.Date(parsed.getTime());
//		user.updateUser("P5", "Omkara", "Mumbai", "MALE", sql, "password");
		
//		user.addAUserAsHealthSupporter(u4, u1, "PRIMARY", sql);
		
//		HealthSystemUser u = new HealthSystemUser();
//		HealthSystemUser v = new HealthSystemUser();
//		Observation o=new Observation();
//		u.setId("P4");
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
////        Date parsed = format.parse("20110210");
//        Date temp=sdf.parse("2016-10-17 00:00:00");
//        u.setId("P3");
//        v.setId("P2");
//        o.setId(5);
////        java.sql.Date sql = new java.sql.Date(parsed.getTime());
//        java.sql.Date sql_temp = new java.sql.Date(temp.getTime());
//		//user.insertUser("P5", "Omkar", "Mumbai", "MALE", sql, "password");
//        RecordController record = new RecordController();
//		record.insertRecord(2,u,v, o, 195, sql_temp,sql_temp);
		
//		System.out.println(user.getHealthSupporters(u));
		
		try {
//			user.setDiagnoses(u, disease, date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}

}
