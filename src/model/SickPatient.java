package model;

public class SickPatient {
		
	private String sickPatientId;
	
	private HealthSystemUser user;
	
	private Disease disease;

	public String getSickPatientId() {
		return sickPatientId;
	}

	public void setSickPatientId(String sickPatientId) {
		this.sickPatientId = sickPatientId;
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
