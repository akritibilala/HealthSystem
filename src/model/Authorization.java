package model;

public class Authorization {
	
	private HealthSystemUser patient;
	
	private HealthSystemUser healthSupporter;
	
	private String healthSupporterType;
	
	private String authorizationDate;

	public HealthSystemUser getPatient() {
		return patient;
	}

	public void setPatient(HealthSystemUser patient) {
		this.patient = patient;
	}

	public HealthSystemUser getHealthSupporter() {
		return healthSupporter;
	}

	public void setHealthSupporter(HealthSystemUser healthSupporter) {
		this.healthSupporter = healthSupporter;
	}

	public String getHealthSupporterType() {
		return healthSupporterType;
	}

	public void setHealthSupporterType(String healthSupporterType) {
		this.healthSupporterType = healthSupporterType;
	}

	public String getAuthorizationDate() {
		return authorizationDate;
	}

	public void setAuthorizationDate(String authorizationDate) {
		this.authorizationDate = authorizationDate;
	}
	
	

}
