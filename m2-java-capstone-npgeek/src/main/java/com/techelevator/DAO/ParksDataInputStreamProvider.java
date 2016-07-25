package com.techelevator.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ParksDataInputStreamProvider implements ParksDataStreamProvider {
		
	private File parksFile;

	@Autowired
	public ParksDataInputStreamProvider(@Value("classpath:parks_config.properties") InputStream parksFile) {
		Properties config = loadConfiguration(parksFile);
		this.parksFile = new File(config.getProperty("parkDataPath"));

	}
	@Override
	public InputStream getInputStream() {
		try {
			if(!parksFile.exists()) {
				parksFile.createNewFile();
			}
			return new FileInputStream(parksFile);
		} catch (IOException e) {
			throw new RuntimeException("Could not find or create suggestion data file: "+parksFile.getAbsolutePath(), e);
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
