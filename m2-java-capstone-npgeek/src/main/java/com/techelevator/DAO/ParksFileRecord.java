package com.techelevator.DAO;

public class ParksFileRecord {

	private String parkCode;
	private String name;
	private String state;
	private String acreage;
	private String elevation;
	private String milesOfTrails;
	private String numberOfCampsites;
	private String climate;
	private String yearFounded;
	private String annualNumberOfVisitors;
	private String famousQuote;
	private String famousQuoteSource;
	private String description;
	private String entryFee;
	private String numberOfAnimalSpecies;
	
	public ParksFileRecord(String record) {
		
		String[] recordParts = record.split("\t");
		this.parkCode = recordParts[0].toLowerCase();
		this.name = recordParts[1];
		this.state = recordParts[2];
		this.acreage = recordParts[3];
		this.elevation = (recordParts[4]);
		this.milesOfTrails = (recordParts[5]);
		this.numberOfCampsites = (recordParts[6]);
		this.climate = recordParts[7];
		this.yearFounded = (recordParts[8]);
		this.annualNumberOfVisitors = (recordParts[9]);
		this.famousQuote = recordParts[10];
		this.famousQuoteSource = recordParts[11];
		this.description = recordParts[12];
		this.entryFee = (recordParts[13]);
		this.numberOfAnimalSpecies = (recordParts[14]);
	
	}
	
	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAcreage() {
		return acreage;
	}

	public void setAcreage(String acreage) {
		this.acreage = acreage;
	}

	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	public String getMilesOfTrails() {
		return milesOfTrails;
	}

	public void setMilesOfTrails(String milesOfTrails) {
		this.milesOfTrails = milesOfTrails;
	}

	public String getNumberOfCampsites() {
		return numberOfCampsites;
	}

	public void setNumberOfCampsites(String numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(String yearFounded) {
		this.yearFounded = yearFounded;
	}

	public String getAnnualNumberOfVisitors() {
		return annualNumberOfVisitors;
	}

	public void setAnnualNumberOfVisitors(String annualNumberOfVisitors) {
		this.annualNumberOfVisitors = annualNumberOfVisitors;
	}

	public String getFamousQuote() {
		return famousQuote;
	}

	public void setFamousQuote(String famousQuote) {
		this.famousQuote = famousQuote;
	}

	public String getFamousQuoteSource() {
		return famousQuoteSource;
	}

	public void setFamousQuoteSource(String famousQuoteSource) {
		this.famousQuoteSource = famousQuoteSource;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(String entryFee) {
		this.entryFee = entryFee;
	}

	public String getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}

	public void setNumberOfAnimalSpecies(String numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}
}
