package model;

public class Recommendation {
		
	private String id;
	
	private Double lowerLimit;
	
	private Double upperLimit;
	
	private Integer frequency;
	
	private String text;
	
	private HealthSupporter healthSupporter;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(Double lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public Double getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(Double upperLimit) {
		this.upperLimit = upperLimit;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public HealthSupporter getHealthSupporter() {
		return healthSupporter;
	}

	public void setHealthSupporter(HealthSupporter healthSupporter) {
		this.healthSupporter = healthSupporter;
	}
	
	@Override
	public String toString() {
		return "[LOWER_LIMIT = "+lowerLimit+" UPPER_LIMIT = "+upperLimit+" FREQUENCY = "+frequency+" TEXT = "+text+"]";
	}

}
