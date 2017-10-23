package edu.csupomona.cs480.data.provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.csupomona.cs480.data.FlashCardSet;
import edu.csupomona.cs480.data.FlashCardSetMap;
import edu.csupomona.cs480.util.ResourceResolver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of {@link FlashCardSetManager} interface
 * using file system.
 * <p>
 */
public class FSFlashCardSetManager implements FlashCardSetManager{

	private static final ObjectMapper JSON = new ObjectMapper();

	/**
	 * Load the flash card set map from the local file.
	 *
	 * @return
	 */
	private FlashCardSetMap getFlashCardSetMap() {
		FlashCardSetMap flashCardSetMap = null;
		File flashCardSetFile = ResourceResolver.getFlashCardSetFile();
		if (flashCardSetFile.exists()) {
			// read the file and convert the JSON content
			// to the UserMap object
			try {
				flashCardSetMap = JSON.readValue(flashCardSetFile, FlashCardSetMap.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			flashCardSetMap = new FlashCardSetMap();
		}
		return flashCardSetMap;
	}

	/**
	 * Save and persist the flash card set map in the local file.
	 *
	 * @param flashCardSetMap
	 */
	private void presistFlashCardSetMap(FlashCardSetMap flashCardSetMap) {
		try {
			// convert the user object to JSON format
			JSON.writeValue(ResourceResolver.getFlashCardSetFile(), flashCardSetMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public FlashCardSet getFlashCardSet(String id) {
		FlashCardSetMap fcsMap = getFlashCardSetMap();
		return fcsMap.get(id);
	}

	@Override
	public void updateFlashCardSet(FlashCardSet set) {
		FlashCardSetMap fcsMap = getFlashCardSetMap();
		fcsMap.put(set.getId(), set);
		presistFlashCardSetMap(fcsMap);
	}

	@Override
	public void deleteFlashCardSet(String id) {
		FlashCardSetMap fcsMap = getFlashCardSetMap();
		fcsMap.remove(id);
		presistFlashCardSetMap(fcsMap);
	}

	@Override
	public List<String[]> listAllFlashCardSetIdNamePairs() {
		FlashCardSetMap fcsMap = getFlashCardSetMap();
		ArrayList<String[]> pairArrayList = new ArrayList<>();
		for ( FlashCardSet f : fcsMap.values()){
			String[] pair = {f.getId(), f.getName()};
			pairArrayList.add(pair);
		}
		return pairArrayList;
	}

	@Override
	public FlashCardSet parseJSON(String text) {
		FlashCardSet flashCardSet = null;

		try {
			flashCardSet = JSON.readValue(text, FlashCardSet.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return flashCardSet;

	}

	@Override
	public String serializeJSON(FlashCardSet set) {
		try {
			return JSON.writeValueAsString(set);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
