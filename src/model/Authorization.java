package model;

import java.util.Date;

public class Authorization {
	
	private HealthSystemUser patient;
	
	private HealthSupporter healthSupporter;
	
	private String healthSupporterType;
	
	private Date authorizationDate;

	public HealthSystemUser getPatient() {
		return patient;
	}

	public void setPatient(HealthSystemUser patient) {
		this.patient = patient;
	}

	public HealthSupporter getHealthSupporter() {
		return healthSupporter;
	}

	public void setHealthSupporter(HealthSupporter healthSupporter) {
		this.healthSupporter = healthSupporter;
	}

	public String getHealthSupporterType() {
		return healthSupporterType;
	}

	public void setHealthSupporterType(String healthSupporterType) {
		this.healthSupporterType = healthSupporterType;
	}

	public Date getAuthorizationDate() {
		return authorizationDate;
	}

	public void setAuthorizationDate(Date authorizationDate) {
		this.authorizationDate = authorizationDate;
	}
	
	@Override
	public String toString() {
		return "[PATIENT = "+patient.toString()+" HEALTH_SUPPORTER = "+healthSupporter.toString()+" AUTH_DATE = "+authorizationDate+" TYPE = "+healthSupporterType+"]";
	}

}
