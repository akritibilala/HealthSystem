package model;

public class SpecialRecommendation {
		
	private String id;
	
	private Recommendation recommendation;
	
	private HealthSupporter healthSupporter;
	
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
	

}
