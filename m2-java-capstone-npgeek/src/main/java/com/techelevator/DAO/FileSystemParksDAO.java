package com.techelevator.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 
import com.techelevator.model.Parks;

@Component
public class FileSystemParksDAO implements ParksDAO {

	private ParksDataInputStreamProvider parksDataStream;
	
	@Autowired
	public FileSystemParksDAO(ParksDataInputStreamProvider parksDataStream) {
		this.parksDataStream = parksDataStream;
	}

	@Override
	public List<Parks> getAllParks() {
		ArrayList<Parks> parks = new ArrayList<>();
		try(Scanner parksFileScanner = new Scanner(parksDataStream.getInputStream())) {
			while(parksFileScanner.hasNextLine()) {
				ParksFileRecord park = new ParksFileRecord(parksFileScanner.nextLine());
				Parks p = new Parks(park.getParkCode(), park.getName(), park.getState(), park.getAcreage(), park.getElevation(),
									park.getMilesOfTrails(), park.getNumberOfCampsites(), park.getClimate(), park.getYearFounded(),
									park.getAnnualNumberOfVisitors(), park.getFamousQuote(), park.getFamousQuoteSource(),
									park.getDescription(), park.getEntryFee(), park.getNumberOfAnimalSpecies());
				parks.add(p);
			}
		}
		return parks;
	}

	@Override
	public Parks getParkByCode(String parkCode) {
		Parks result = null;
		for(Parks p : getAllParks()) {
			if(p.getParkCode().equals(parkCode)) {
				result = p;
			}
		}
		return result;
	}
}
