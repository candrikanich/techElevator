package com.techelevator.DAO;

import java.io.InputStream;
import java.io.OutputStream;

public interface SurveyDataStreamProvider {

		public InputStream getInputStream();
		public OutputStream getOutputStream();
	}



