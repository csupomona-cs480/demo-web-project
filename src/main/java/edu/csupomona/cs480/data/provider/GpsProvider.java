package edu.csupomona.cs480.data.provider;

import java.util.List;

import edu.csupomona.cs480.data.GpsItem;

public interface GpsProvider {

	public List<GpsItem> listAllGpsItems();
	
}
