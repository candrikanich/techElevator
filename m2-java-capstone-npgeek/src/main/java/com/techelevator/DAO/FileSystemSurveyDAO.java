package com.techelevator.DAO;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techelevator.model.Survey;

@Component
public class FileSystemSurveyDAO implements SurveyDAO {

		private SurveyDataStreamProvider surveyDataStream;

		@Autowired 
		public FileSystemSurveyDAO(SurveyDataStreamProvider surveyDataStream) {
			this.surveyDataStream = surveyDataStream;
		}

		
		@Override
		public List<Survey> getResponse() {
			ArrayList<Survey> survey = new ArrayList<>();
 			try(Scanner surveyFileScanner = new Scanner(surveyDataStream.getInputStream())) {
				while(surveyFileScanner.hasNextLine()) {
					SurveyRecord survey1 = new SurveyRecord(surveyFileScanner.nextLine());
					Survey s = new Survey(survey1.getParkCode());
 					survey.add(s);
				}
			}
			return survey;
		}

		@Override
		public void saveSurveyResponse(Survey survey) {
			try(PrintWriter writer = new PrintWriter(surveyDataStream.getOutputStream())) {
				//SurveyRecord record = new SurveyRecord(survey);
				writer.println(survey.getParkCode());
			}			
		}

		@Override
		public Map<String, Integer>getSurveyResults() {
 			Map<String, Integer>results = new LinkedHashMap<>();
 			List<Survey> survey = getResponse();
 			Integer numVotes;
			for(Survey s : survey) {
				
				if (results.get(s.getParkCode()) != null) {
					numVotes = results.get(s.getParkCode()) + 1;
				}else{
					numVotes = 1;
				}
 				results.put(s.getParkCode(), numVotes);
 			}
			return results;
		}
		
}
