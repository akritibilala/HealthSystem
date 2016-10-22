package model;

public class Alert {
		
	private String id;
	
	private String type;
	
	private String status;
	
	private String alertMessage;
	
	private String date;
	
	private Observation obsType;
	
	private HealthSystemUser patient;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Observation getObsType() {
		return obsType;
	}

	public void setObsType(Observation obsType) {
		this.obsType = obsType;
	}

	public HealthSystemUser getPatient() {
		return patient;
	}

	public void setPatient(HealthSystemUser patient) {
		this.patient = patient;
	}

}
