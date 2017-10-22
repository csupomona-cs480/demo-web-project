package edu.csupomona.cs480.data.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


/**
 * The basic user object.
 */
@Entity
public class User {

	/** The unique user Id */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    /** The unique user Id */
    private String name;
    /** The unique user Id */
    private String major;
    @Version
    private Integer version;
    private String email;
    private String userId;
    /** The timestamp when the user is being created */
    private String creationTime = new Date(System.currentTimeMillis()).toString();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
}
