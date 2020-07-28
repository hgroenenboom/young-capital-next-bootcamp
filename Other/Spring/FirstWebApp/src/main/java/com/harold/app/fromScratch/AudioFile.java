package com.harold.app.fromScratch;


// Entity
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


// Repository (CRUD)
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// Service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// Controller
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;



// Objects / data? -> Wordt automatisch een tabel : Model
@Entity
public class AudioFile {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idtest;
}


// Controller -> CRUD operations (automatisch). Eerste laag op DB
@Repository
interface AudioFileRepository extends CrudRepository<AudioFile, Integer> {
	
}


// Controller -> Laag op de CRUD operations, CRUD is basaal.
@Service
@Transactional
class AudioFileService {
	@Autowired
	private AudioFileRepository repo;
	
	public AudioFile saveNew(AudioFile file){
		return repo.save(file);
	}
}


// View: Endpoint: Officieel dus view, maar genereert vaak geen HTML! = connectie van frontend to backend.
@Controller
@RequestMapping(path="/audiofile")
class AudioFileController {
	@Autowired
	private AudioFileService service;
	
	@GetMapping(path="/test")
	public @ResponseBody String getString() {
	 	return "test";
	}
	  
	@GetMapping(path="/add") 
	public @ResponseBody AudioFile createAudioFile() {
		AudioFile f = new AudioFile();
		service.saveNew(f);
		return f;
	}
}

