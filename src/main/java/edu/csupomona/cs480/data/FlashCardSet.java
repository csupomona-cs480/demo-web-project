package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.List;

public class FlashCardSet {

	/**
	 * A human-identifiable string related to this flash card set
	 */
	private String name;
	/**
	 * The user who owns this set
	 */
	private String user;
	/**
	 * The unique id of this set
	 */
	private String id;
	/**
	 * The flash cards this set contains
	 */
	private List<FlashCard> flashcards;

	public FlashCardSet() {
		flashcards = new ArrayList<>();
		name = "";
		user = "";
		id = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<FlashCard> getFlashcards() {
		return flashcards;
	}

	public void setFlashcards(List<FlashCard> flashcards) {
		this.flashcards = flashcards;
	}

	@Override
	public String toString() {
		return name + "\t" + user + "\t" + id + "\t" + flashcards.toString();
	}
}
