package com.techelevator.DAO;

import java.util.List;

import com.techelevator.model.Weather;

public interface WeatherDAO {

	public List<Weather>getAllWeather(boolean isCelcius);
	public List<Weather> getWeatherByParkCode(String parkCode, boolean isCelcius);
	public void isCelcius(boolean isCelcius);

}
