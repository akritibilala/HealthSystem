package model;

public class AlertPatientInfo {
	
	private int alertPercentageThreshold;
	
	private int alertObservationThreshold;
	
	private int alertFrequencyThreshold;
	
	private Observation observation;
	
	private HealthSystemUser patient;

	public int getAlertPercentageThreshold() {
		return alertPercentageThreshold;
	}

	public void setAlertPercentageThreshold(int alertPercentageThreshold) {
		this.alertPercentageThreshold = alertPercentageThreshold;
	}

	public int getAlertObservationThreshold() {
		return alertObservationThreshold;
	}

	public void setAlertObservationThreshold(int alertObservationThreshold) {
		this.alertObservationThreshold = alertObservationThreshold;
	}

	public int getAlertFrequencyThreshold() {
		return alertFrequencyThreshold;
	}

	public void setAlertFrequencyThreshold(int alertFrequencyThreshold) {
		this.alertFrequencyThreshold = alertFrequencyThreshold;
	}

	public Observation getObservation() {
		return observation;
	}

	public void setObservation(Observation observation) {
		this.observation = observation;
	}

	public HealthSystemUser getPatient() {
		return patient;
	}

	public void setPatient(HealthSystemUser patient) {
		this.patient = patient;
	}

}
