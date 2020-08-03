package com.harold.app.source.audioFile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
import javax.persistence.Basic;


// Objects / data -> Wordt automatisch een tabel : Model
// Getters and Setters are needed in order for the data members to be accessed and registered as columns.
@Entity
public class AudioFile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String filepath = "placeholder"; // Adding a new column/field adds NULL values to the old entries

	@Basic // annotates basic data type to store
    private LocalDateTime addedDate;
	
	// ANNOTATIONS
	// @OneToOne annotation -> Annotation OneToOne possessive relationship
	// @JsonIgnore
    
    public LocalDateTime getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDateTime addedDate) {
		this.addedDate = addedDate;
	}

	public AudioFile() {
    	addedDate = LocalDateTime.now();
    }
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
}

