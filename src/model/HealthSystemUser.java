package model;

import java.sql.Date;
import java.util.Map;

public class HealthSystemUser {
	
	private String id;
	
	private Date dateOfBirth;
	
	private String gender;
	
	private String address;
	
	private String email;
	
	private String password;
	
	private String name;
	
	Map<Observation,Recommendation> obsRecommendationMap;

	public String getId() {
		return id;
	}

	public void setId(String userId) {
		this.id = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}
