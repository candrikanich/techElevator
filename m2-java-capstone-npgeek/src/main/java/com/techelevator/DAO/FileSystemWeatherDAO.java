package com.techelevator.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.techelevator.model.Weather;

@Component
public class FileSystemWeatherDAO implements WeatherDAO{

	private WeatherDataInputStreamProvider weatherDataStream;

	@Autowired
	public FileSystemWeatherDAO(WeatherDataInputStreamProvider weatherDataStream) {
		this.weatherDataStream = weatherDataStream;
	}

	@Override
	public List<Weather> getAllWeather(boolean isCelcius) {
		ArrayList<Weather> allWeather = new ArrayList<>();
		try(Scanner weatherFileScanner = new Scanner(weatherDataStream.getInputStream())) {
			while(weatherFileScanner.hasNextLine()) {
				WeatherFileRecord weather = new WeatherFileRecord(weatherFileScanner.nextLine());
				Weather p = new Weather(weather.getParkCode(), weather.getDay(), weather.getLowTemp(), weather.getHighTemp(),
									weather.getForeCast(), isCelcius);
				allWeather.add(p);
			}
		}
		return allWeather;
	}

	@Override
	public List<Weather> getWeatherByParkCode(String parkCode, boolean isCelcius) {
		List<Weather> result = new ArrayList<>();
		for(Weather w : getAllWeather(isCelcius)) {
			if(w.getParkCode().equals(parkCode)) {
				result.add(w);
			}
		}
		return result;
	}

	@Override
	public void isCelcius(boolean isCelcius) {
		// TODO Auto-generated method stub
		
	}
	
}
