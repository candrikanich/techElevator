package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Weather {

	private String parkCode;
	private int	   day;
	private int lowTemp;
	private int highTemp;
	private String foreCast;
	private boolean isCelcius;
	private List<String> advice;
 
	// constructor value for temperature assumes value is provided as fahrenheit by design
	public Weather (String parkCode, int day, int lowTemp, int highTemp, String foreCast, boolean isCelcius) {
		
		this.parkCode  = parkCode;
		this.day       = day;
		this.isCelcius = isCelcius;
		this.foreCast  = foreCast;
		this.isCelcius = isCelcius;

		// first set temps = farenheit in order to calculate Advice then evaluate and adjust if Celcius
		this.lowTemp = lowTemp;
		this.highTemp = highTemp;		
		this.advice = createAdvice();

		if (isCelcius) {
			this.lowTemp = calculateToCelcius(lowTemp);
			this.highTemp = calculateToCelcius(highTemp);
		}		
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
	
	public boolean isCelcius() {
		return isCelcius;
	}

	public void setCelcius(boolean isCelcius) {
		this.isCelcius = isCelcius;
	}

	public int calculateToCelcius(int temperature){
		
		return ((temperature -32) *5/9);
 		
 	}

	public int calculateToFahrenheit(int temperature){
		
		return ((temperature *5/9)+32);
 		
 	}

	public List<String> createAdvice() {
		
		List<String> advice = new ArrayList<>();
		
		switch(foreCast) {
			case "snow":
				advice.add("&#9731; Pack snowshoes");
				break;
			case "rain":
				advice.add("&#9730; Pack Rain Gear and waterproof shoes");
 				break;
			case "sunny":
				advice.add("&#9728; Pack Sunblock to avoid harmful sun rays");
				break;
			case "thunderstorms":
				advice.add("&#9729; Seek shelter and avoid hiking on exposed ridges or mountaintops");
				break;
				
		}

		if (highTemp > 75 ) {
			advice.add("&#9888; Bring an extra gallon of water");
		}
 
		if (lowTemp < 20) {
			advice.add("&#9888; Frostbite warning in effect today");			
		}

		if (highTemp - lowTemp > 20) {
			advice.add("&#9888; Wear breathable layers");						
		}

		return advice;
		
	}

	public List<String> getAdvice() {
		return advice;
	}
	public void setAdvice(List<String> advice) {
		this.advice = advice;
	}

}
