package com.techelevator.DAO;

import java.io.InputStream;
import java.io.OutputStream;

public interface WeatherDataStreamProvider {

	public InputStream getInputStream();
	public OutputStream getOutputStream();

}
