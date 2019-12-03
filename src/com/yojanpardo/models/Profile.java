package com.yojanpardo.models;
/**
 * 
 * @author yojan
 * Model to load each profile with an extra field named 'industryScore'
 * {@value} industryScore is a file that helps to sort the profiles 
 */
public class Profile {
	private String personId;
	private String name;
	private String lastName;
	private String currentRole;
	private String country;
	private String industry;
	private int numberOfRecomendations;
	private int numberOfConnections;
	private int industryScore;
	
	public int getIndustryScore() {
		return industryScore;
	}
	public void setIndustryScore(int industryScore) {
		this.industryScore = industryScore;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCurrentRole() {
		return currentRole;
	}
	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public int getNumberOfRecomendations() {
		return numberOfRecomendations;
	}
	public void setNumberOfRecomendations(int numberOfRecomendations) {
		this.numberOfRecomendations = numberOfRecomendations;
	}
	public int getNumberOfConnections() {
		return numberOfConnections;
	}
	public void setNumberOfConnections(int numberOfConnections) {
		this.numberOfConnections = numberOfConnections;
	}
	
	@Override
	public String toString() {
		String profile = "personId: " + this.personId;
		profile += ", name: " + this.name;
		profile += ", lastName: " + this.lastName;
		profile += ", currentRole: " + this.currentRole;
		profile += ", country: " + this.country;
		profile += ", industry: " + this.industry;
		profile += ", numberOfRecomendations: " + this.numberOfRecomendations;
		profile += ", numberOfConnections: " + this.numberOfConnections;
		profile += ", industryScore: " + this.industryScore;
		return profile;
	}
}
