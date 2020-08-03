package com.harold.app.fromScratch;


import java.nio.charset.Charset;
import java.util.Random;

// Entity
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

import javax.persistence.Basic;

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
import java.util.Date;
import java.util.Iterator;

import org.springframework.web.bind.annotation.CrossOrigin;
// Controller
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harold.app.felix.domain.Trein;

import org.springframework.stereotype.Controller;


// Endpoint
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.stereotype.Component;


// Objects / data? -> Wordt automatisch een tabel : Model
// Getters and Setters are needed in order for the data members to be accessed and registered as columns.
@Entity
public class AudioFile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String filepath = "placeholder"; // Adding a new column/field adds NULL values to the old entries

	@Basic
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


// Controller -> CRUD operations (automatisch). Eerste laag op DB
@Repository
//interface AudioFileRepository extends CrudRepository<AudioFile, Integer> {	  // This is not a JPA repository, so it doesn't support automatic method names.
interface AudioFileRepository extends JpaRepository<AudioFile, Integer> {	 
	List<AudioFile> findByAddedDateBefore(LocalDateTime time);
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
	
	public @ResponseBody List<AudioFile> findAllBeforeNow() {
		return repo.findByAddedDateBefore(LocalDateTime.now());
	}
	
	public @ResponseBody List<AudioFile> findAllBeforeHoursAgo(long hours) throws Exception {
		if(hours < 0 || hours > 10000)
			throw new Exception();
		
		return repo.findByAddedDateBefore( LocalDateTime.now().minus(hours, ChronoUnit.HOURS) );
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
	
	@GetMapping(path="/findAllBeforeNow")
	public @ResponseBody List<AudioFile> findAllBeforeNow() {
		return service.findAllBeforeNow();
	}
	
	@GetMapping(path="/findAllBefore1HourAgo")
	public @ResponseBody List<AudioFile> findAllBefore1HourAgo() throws Exception {
		return service.findAllBeforeHoursAgo(1L);
	}
	
	@GetMapping(path="/findAllBeforeHoursAgo")
	public @ResponseBody List<AudioFile> findAllBeforeHoursAgo(@RequestParam long hours) throws Exception {
		return service.findAllBeforeHoursAgo(hours);
	}
	
	// =============================================
	// Test custom functions
	// =============================================
	
	@GetMapping(path="/add") 
	@CrossOrigin(origins = "http://localhost:8083")
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


// UNUSED
/*
//========================================================================
// ENDPOINT
@Path("audiofiledata")
@Component
class AudioFileEndpoint {
	@Autowired
	private AudioFileService service;
	
	@GET
	@CrossOrigin(origins = "http://localhost:8083")
	@Produces(MediaType.APPLICATION_JSON)
	public Response all_files() {
		return Response.ok(service.findAll()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postAllFiles(AudioFile file){
		AudioFile result = service.saveNew(file);
		return Response.accepted(result.getId()).build();	
	}
}
*/


