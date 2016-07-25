package com.techelevator.DAO;

public class WeatherFileRecord {

	private String parkCode;
	private int	   day;
	private int lowTemp;
	private int highTemp;
	private String foreCast;
	private boolean isCelcius;

 
	public WeatherFileRecord (String record) {
		
		String[] recordParts = record.split("\t");
		this.parkCode = recordParts[0].toLowerCase();
		this.day = Integer.parseInt(recordParts[1]);
		this.lowTemp = Integer.parseInt(recordParts[2]);
		this.highTemp = Integer.parseInt(recordParts[3]);
		this.foreCast = (recordParts[4]);
		this.isCelcius = false;
	}
	
	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getLowTemp() {
		return lowTemp;
	}

	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}

	public int getHighTemp() {
		return highTemp;
	}

	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp;
	}

	public String getForeCast() {
		return foreCast;
	}

	public void setForeCast(String foreCast) {
		this.foreCast = foreCast;
	}

}
