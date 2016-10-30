package model;

import java.sql.Date;
import java.util.Map;

public class HealthSystemUser {
	
	private String id;
	
	private Date dateOfBirth;
	
	private String gender;
	
	private String address;
	
	private String password;
	
	private String name;
	
	private String type;
	
	Map<Observation,Recommendation> obsRecommendationMap;
	
	public HealthSystemUser() {
	}

	public HealthSystemUser(String id, Date dateOfBirth, String gender, String address,String name,String type) {
		super();
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.name = name;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String userId) {
		this.id = userId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type= type;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<Observation, Recommendation> getObsRecommendationMap() {
		return obsRecommendationMap;
	}

	public void setObsRecommendationMap(Map<Observation, Recommendation> obsRecommendationMap) {
		this.obsRecommendationMap = obsRecommendationMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[NAME ="+name+" ADDRESS = "+address+" GENDER = "+gender+" DOB = "+dateOfBirth+"]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Observation)
		{
			HealthSystemUser user = (HealthSystemUser) obj;
			return this.getId().equals(user.getId());
		}
		else
		return super.equals(obj);
	}

}
