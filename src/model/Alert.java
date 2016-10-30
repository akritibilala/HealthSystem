package model;

import java.sql.Date;

public class Alert {
		
	private int id;
	
	private String type;
	
	private String status;
	
	private String alertMessage;
	
	private Date date;
	
	private Observation obsType;
	
	private HealthSystemUser patient;
	
	public Alert(int id,String type,String status,String alertMessage,Date date,Observation observation)
	{
		this.id = id;
		this.type = type;
		this.status = status;
		this.alertMessage = alertMessage;
		this.date = date;
		this.obsType = observation;
	}
	
	public Alert(int id,String type,String status,String alertMessage,Date date,Observation observation,HealthSystemUser patient)
	{
		this.id = id;
		this.type = type;
		this.status = status;
		this.alertMessage = alertMessage;
		this.date = date;
		this.obsType = observation;
		this.patient = patient;
	}

	public Alert() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
