package model;

public class Record {
	
	private String id;
	
	private HealthSupporter healthSupporter;
	
	private HealthSystemUser patient;
	
	private Observation obsType;
	
	private String value;
	
	private String obsDateTime;
	
	private String recDateTime;

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

	public String getObsDateTime() {
		return obsDateTime;
	}

	public void setObsDateTime(String obsDateTime) {
		this.obsDateTime = obsDateTime;
	}

	public String getRecDateTime() {
		return recDateTime;
	}

	public void setRecDateTime(String recDateTime) {
		this.recDateTime = recDateTime;
	}
	
	
}
