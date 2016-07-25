package com.techelevator.DAO;

import java.util.List;

import com.techelevator.model.Parks;

public interface ParksDAO {

	public List<Parks>getAllParks( );
	public Parks getParkByCode(String parkCode);

}
