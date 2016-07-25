package com.techelevator.DAO;

import com.techelevator.model.Survey;

public class SurveyRecord {
	private String parkCode;
		
	public SurveyRecord(String parkCode) {
		this.parkCode = parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;

	}

	public String getParkCode() {
		return parkCode;
	}	
}
