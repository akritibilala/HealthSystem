package model;

public class SickPatient {
		
	private String id;
	
	private HealthSystemUser user;
	
	private Disease disease;

	public String getId() {
		return id;
	}

	public void setId(String sickPatientId) {
		this.id = sickPatientId;
	}

	public HealthSystemUser getUser() {
		return user;
	}

	public void setUser(HealthSystemUser user) {
		this.user = user;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	
	

}
