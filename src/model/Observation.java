package model;

public class Observation {
	
	private Integer id;
	
	private String type;
	
	private String description;
	
	private String measure;
	
	private String metric;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Observation)
		{
			Observation obs = (Observation) obj;
			return this.getId().equals(obs.getId());
		}
		else
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public String toString() {
		return "[ID = "+id+" TYPE = "+type+" DESCRIPTION "+description+" MEASURE = "+measure+" METRIC = "+metric+"]";
	}


}
