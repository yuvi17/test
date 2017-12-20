package com.library.models;

import org.springframework.stereotype.Repository;

@Repository
public class Book {
	
	private String Id;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
	}

	private String title;
	
	private String author;
	
	private String description;
	
	private String status;
	
	private String addedTimeStamp;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the addedTimeStamp
	 */
	public String getAddedTimeStamp() {
		return addedTimeStamp;
	}

	/**
	 * @param addedTimeStamp the addedTimeStamp to set
	 */
	public void setAddedTimeStamp(String addedTimeStamp) {
		this.addedTimeStamp = addedTimeStamp;
	}
	

}
