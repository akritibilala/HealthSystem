package model;

import java.sql.Date;

public class Record {
	
	private String id;
	
	private HealthSupporter healthSupporter;
	
	private HealthSystemUser patient;
	
	private Observation obsType;
	
	private String value;
	
	private Date obsDateTime;
	
	private Date recDateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HealthSupporter getHealthSupporter() {
		return healthSupporter;
	}

	public void setHealthSupporter(HealthSupporter healthSupporter) {
		this.healthSupporter = healthSupporter;
	}

	public HealthSystemUser getPatient() {
		return patient;
	}

	public void setPatient(HealthSystemUser patient) {
		this.patient = patient;
	}

	public Observation getObsType() {
		return obsType;
	}

	public void setObsType(Observation obsType) {
		this.obsType = obsType;
	}

	public String getValue() {
		return value;
	}
	

	public void setValue(String value) {
		this.value = value;
	}

	public Date getObsDateTime() {
		return obsDateTime;
	}

	public void setObsDateTime(Date obsDateTime) {
		this.obsDateTime = obsDateTime;
	}

	public Date getRecDateTime() {
		return recDateTime;
	}

	public void setRecDateTime(Date recDateTime) {
		this.recDateTime = recDateTime;
	}
	
	
}
