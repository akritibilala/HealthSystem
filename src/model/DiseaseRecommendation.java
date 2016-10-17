package model;

public class DiseaseRecommendation {
		
	private String id;
	
	private Disease disease;
	
	private Recommendation recommendation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public Recommendation getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(Recommendation recommendation) {
		this.recommendation = recommendation;
	}
	
	

}
