package model;

public class SpecialRecommendation {
		
	private String id;
	
	private Recommendation recommendation;
	
	private HealthSystemUser healthSupporter;
	
	private HealthSystemUser patient;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Recommendation getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(Recommendation recommendation) {
		this.recommendation = recommendation;
	}

	public HealthSystemUser getHealthSupporter() {
		return healthSupporter;
	}

	public void setHealthSupporter(HealthSystemUser healthSupporter) {
		this.healthSupporter = healthSupporter;
	}

	public HealthSystemUser getPatient() {
		return patient;
	}

	public void setPatient(HealthSystemUser patient) {
		this.patient = patient;
	}
	

}
