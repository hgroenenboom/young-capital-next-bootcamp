package com.harold.app.fromScratch;


import java.nio.charset.Charset;
import java.util.Random;

// Entity
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

// Repository (CRUD)
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


// Service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Iterator;


// Controller
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;



// Objects / data? -> Wordt automatisch een tabel : Model
@Entity
public class AudioFile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String filepath = "placeholder"; // Adding a new collumn/field adds NULL values to the old entries

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


// Controller -> CRUD operations (automatisch). Eerste laag op DB
@Repository
interface AudioFileRepository extends CrudRepository<AudioFile, Integer> {	  // This is not a JPA repository, so it doesn't support automatic method names.
//interface AudioFileRepository extends JpaRepository<AudioFile, Integer> {	 
	
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

	public Iterable<AudioFile> findByFilepath(String filepath) {
		System.out.println(filepath);
		Iterable<AudioFile> files = repo.findAll();
		List<AudioFile> selectedFiles = new ArrayList<AudioFile>();
		for(AudioFile f : files) {
			if(f.getFilepath().contains(filepath)) {
				selectedFiles.add(f);
			}
		}
		System.out.println(selectedFiles);
		return (Iterable<AudioFile>) selectedFiles;
	}
	
	public Optional<AudioFile> findById(Integer id) {
		return repo.findById(id);
	}
	
	public Iterable<AudioFile> findAll() {
		return repo.findAll();
	}
}


// View: Endpoint: Officieel dus view, maar genereert vaak geen HTML! = connectie van frontend to backend.
@Controller
@RequestMapping(path="/audiofile")
class AudioFileController {
	@Autowired
	private AudioFileService service;
	
	// ============================================
	// Test mapping
	// ============================================
	
	@GetMapping(path="/test")
	public @ResponseBody String getString() {
	 	return "test";
	}
	
	// ============================================
	// Test automatic Repository methods
	// =============================================
	
	@GetMapping(path="/findFileById")
	public @ResponseBody AudioFile findByID(@RequestParam Integer id) {
		Optional<AudioFile> opt = service.findById(id);
		return opt.isPresent() ? opt.get() : new AudioFile();
	}
	
	@GetMapping(path="/findAll")
	public @ResponseBody Iterable<AudioFile> findAll() {
		return service.findAll();
	}
	
	// =============================================
	// Test custom functions
	// =============================================
	
	@GetMapping(path="/add") 
	public @ResponseBody AudioFile createAudioFile() {
		AudioFile f = new AudioFile();
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("https://www.freesound.org/");
		
		char[] chars = new char[10];
		for(int i = 0; i < chars.length; i++) {
			chars[i] = (char)(97 + (new Random().nextInt(26)) );
		}
		sBuilder.append(chars);
		
		final int format = new Random().nextInt(4);
		final String[] extensions = { ".wav", ".mp3", ".m4a", ".flac" };
		sBuilder.append(extensions[format]);
		
		f.setFilepath(sBuilder.toString());
		
		service.saveNew(f);
		return f;
	}
	
	@GetMapping(path="/addBatch")
	public @ResponseBody List<AudioFile> createAudioFileBatch(@RequestParam Optional<Integer> num) throws Exception {
		final int NUMFILES = num.isPresent() ? Math.min( Math.max(num.get(), 1), 1000 ) : 100;
		if(NUMFILES < 1 || NUMFILES > 1000) {
			throw new Exception();
		}
		
		List<AudioFile> audiofiles = new ArrayList<AudioFile>();
		for(int i = 0; i < NUMFILES; i++) {
			audiofiles.add(createAudioFile());
		}
		return audiofiles;
	}

	@GetMapping(path="/findFile")
	public @ResponseBody Iterable<AudioFile> findAudioFiles(@RequestParam String name) {
		Iterable<AudioFile> files = service.findByFilepath(name);
		if(name.charAt(0) == '"') {
			System.out.println("string parameters shouldn't be surrounded by \"\"!!  ");
		}
		return files;
	}
}

