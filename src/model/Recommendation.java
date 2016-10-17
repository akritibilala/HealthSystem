package model;

public class Recommendation {
		
	private String id;
	
	private String type;
	
	private ObservationType obsType;
	
	private Double lowerLimit;
	
	private Double upperLimit;
	
	private Integer frequency;
	
	private String text;
	
	private Double alertPercentageThreshold;
	
	private Double alertObsThreshold;
	
	private Double alertFrequencyThreshold;
	
	

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

	public ObservationType getObsType() {
		return obsType;
	}

	public void setObsType(ObservationType obsType) {
		this.obsType = obsType;
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

	public Double getAlertPercentageThreshold() {
		return alertPercentageThreshold;
	}

	public void setAlertPercentageThreshold(Double alertPercentageThreshold) {
		this.alertPercentageThreshold = alertPercentageThreshold;
	}

	public Double getAlertObsThreshold() {
		return alertObsThreshold;
	}

	public void setAlertObsThreshold(Double alertObsThreshold) {
		this.alertObsThreshold = alertObsThreshold;
	}

	public Double getAlertFrequencyThreshold() {
		return alertFrequencyThreshold;
	}

	public void setAlertFrequencyThreshold(Double alertFrequencyThreshold) {
		this.alertFrequencyThreshold = alertFrequencyThreshold;
	}	

}
