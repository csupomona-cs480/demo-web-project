package edu.csupomona.cs480.data.provider;

import edu.csupomona.cs480.data.FlashCardSet;

import java.util.List;

public interface FlashCardSetManager {

	/**
	 * Get the flashCardSet object based on
	 * the given id.
	 * <p>
	 * If the flashCardSet does not exist, return null
	 *
	 * @param id
	 * @return the FlashCardSet object
	 */
    FlashCardSet getFlashCardSet(String id);

	/**
	 * Update the given FlashCardSet object and persist it.
	 * <p>
	 * If the FlashCardSet does not exist before, this
	 * method will create a new record; otherwise,
	 * it will overwrite whatever is currently
	 * being stored.
	 *
	 * @param set object
	 */
    void updateFlashCardSet(FlashCardSet set);

	/**
	 * Delete the given FlashCardSet from the storage.
	 *
	 * @param id
	 */
    void deleteFlashCardSet(String id);

	/**
	 * List all the current sets in the storage.
	 *
	 * @return
	 */
    List<String[]> listAllFlashCardSetIdNamePairs();

	/**
	 * Turns a JSON string into an object
	 *
	 * @return the object
	 */
    FlashCardSet parseJSON(String text);

	/**
	 * Turns an object into a JSON string
	 *
	 * @return the txt of the object
	 */
    String serializeJSON(FlashCardSet set);
}
