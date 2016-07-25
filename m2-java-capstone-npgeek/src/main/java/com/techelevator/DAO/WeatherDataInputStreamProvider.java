package com.techelevator.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherDataInputStreamProvider implements WeatherDataStreamProvider {
			
	private File weatherFile;

	@Autowired
	public WeatherDataInputStreamProvider(@Value("classpath:parks_config.properties") InputStream weatherFile) {
		Properties config = loadConfiguration(weatherFile);
		this.weatherFile = new File(config.getProperty("weatherDataPath"));
	}
			
	public InputStream getInputStream() {
		try {
			if(!weatherFile.exists()) {
				weatherFile.createNewFile();
			}
			return new FileInputStream(weatherFile);
		} catch (IOException e) {
			throw new RuntimeException("Could not find or create suggestion data file: "+weatherFile.getAbsolutePath(), e);
		}
	}
	private Properties loadConfiguration(InputStream configData) {
		try {
			Properties config = new Properties();
			config.load(configData);
			return config;
		} catch (IOException e) {
			throw new RuntimeException("An error occurred while loading config file", e);
		}
	}

	@Override
	public OutputStream getOutputStream() {
		// TODO Auto-generated method stub
		return null;
	}

}


