package com.techelevator.DAO;

import java.util.List;
import java.util.Map;

import com.techelevator.model.Survey;

public interface SurveyDAO {

	public void saveSurveyResponse (Survey survey);
	public List<Survey> getResponse();
	public Map<String, Integer>getSurveyResults(); 
	
}
