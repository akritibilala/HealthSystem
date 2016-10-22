package model;

public class Disease {
	
	private Integer diseaseId;
	
	private String name;
	
	public Integer getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(Integer diseaseId) {
		this.diseaseId = diseaseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[DISEASE NAME = "+name+"]";
	}
	

}
