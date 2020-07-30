package com.harold.app.fromScratch;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harold.app.fromScratch.AudioFile;

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

@Repository
interface AudioFileDataRepository extends JpaRepository<AudioFileData, Integer> {

}

class AudioFileDataService {
	@Autowired
	private AudioFileDataRepository repo;
}

@RequestMapping("audiofiledata")
@RestController
class AudioDataController {
	@GetMapping(path="/test")
	String log() {
		System.out.println("test callable");
		return "test";
	}
}