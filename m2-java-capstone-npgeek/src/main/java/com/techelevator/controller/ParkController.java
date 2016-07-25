package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.techelevator.DAO.ParksDAO;
import com.techelevator.DAO.SurveyDAO;
import com.techelevator.DAO.WeatherDAO;
import com.techelevator.model.Survey;

@Controller
@SessionAttributes(value={"parks", "park", "weather", "isCelcius", "parkCode", "survey", "allSurveys"})
public class ParkController {

	private ParksDAO parksDAO;
	private WeatherDAO weatherDAO;
	private SurveyDAO surveyDAO;
	
	@Autowired
	public ParkController(ParksDAO parksDAO, WeatherDAO weatherDAO, SurveyDAO surveyDAO) {
		this.parksDAO = parksDAO;
		this.weatherDAO = weatherDAO;
		this.surveyDAO = surveyDAO;
	}
	
	public ParkController() {
	}
	
	@RequestMapping(path={"/", "/parkListing"}, method=RequestMethod.GET)
	public String displayParkListing(ModelMap model) {
		
		model.put("parks", parksDAO.getAllParks());
		
		if (model.get("isCelcius") == null){
			model.put("isCelcius", false);			
		}
		return "parkListing";
	}
	
	@RequestMapping(path={"parkDetail"}, method=RequestMethod.GET)
	public String displayParkListing(@RequestParam String parkCode,
									 ModelMap model) {
		
		boolean isCelcius = (boolean)model.get("isCelcius");
		model.put("park", parksDAO.getParkByCode(parkCode));
		model.put("weather", weatherDAO.getWeatherByParkCode(parkCode, isCelcius));
		model.put("parkCode",  parkCode);
 		return "parkDetail";
	}
	
	@RequestMapping(path={"parkDetail"}, method=RequestMethod.POST)
	public String postParkListing(@RequestParam Boolean isCelcius,
								   RedirectAttributes redirectAttributes,
								   ModelMap model) {
		
		model.put("isCelcius", isCelcius);
		redirectAttributes.addAttribute("parkCode", model.get("parkCode"));
		return "redirect:/parkDetail";
	}
	
	@RequestMapping(path={"dailySurveyInput"}, method=RequestMethod.GET)
	public String displaySurveyInput(ModelMap model) {
		
		model.put("allSurveys", surveyDAO.getSurveyResults());
		return "dailySurveyInput";
	}
	
	@RequestMapping(path={"addSurvey"}, method=RequestMethod.POST)
	public String displaySurveyResult(@RequestParam String parkCode,
										ModelMap model) {
		
		model.put("survey", parkCode);
		Survey survey = new Survey(parkCode);
		surveyDAO.saveSurveyResponse(survey);
		
		return "redirect:/dailySurveyInput";
 	}

}
