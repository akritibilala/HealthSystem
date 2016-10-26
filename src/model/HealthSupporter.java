package model;

import java.sql.Date;

public class HealthSupporter extends HealthSystemUser{

	public HealthSupporter(String id, Date dateOfBirth, String gender, String address, String name) {
		super(id, dateOfBirth, gender, address, name,"Health Supporter");
	}
	
	public HealthSupporter() {
	}
		
}
