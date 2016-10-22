package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import controller.UserController;
import model.HealthSystemUser;

public class TestMain {
	
	public static void main(String[] args) throws ParseException {
		UserController user = new UserController();
		HealthSystemUser u = new HealthSystemUser();
		u.setId("P4");
//		Map<String,Recommendation> rec = user.getRecommendations(u);
//		printMap(rec);
//		System.out.println(user.getDiagnoses(u));
//		Disease disease = new Disease();
//		disease.setDiseaseId(1);
//		disease.setName("HIV");
//		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//		user.setDiagnoses(u, disease, date);
//		System.out.println(user.login("P1", "password"));
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed = format.parse("20110210");
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
		user.insertUser("P5", "Omkar", "Mumbai", "MALE", sql, "password");
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
