package com.harold.app.source.audioFileData;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.harold.app.source.audioFile.AudioFile;

@Entity
public class AudioFileData {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="audio_file_id", referencedColumnName="id")
	private AudioFile audiofile;

	private byte[] data;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	public AudioFile getAudiofile() {
		return audiofile;
	}

	public void setAudiofile(AudioFile audiofile) {
		this.audiofile = audiofile;
	}

}
