package edu.csupomona.cs480.data.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Flashcard {

    //primary key in database
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //for optimistic concurrency control
    @Version
    private Integer version;
	/** The term of the card, user data */
	private String term;
	/** The definition of the card, user data */
	private String definition;
    //set Id
	private String setId;
	//Title
    private String title;

    private String userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
