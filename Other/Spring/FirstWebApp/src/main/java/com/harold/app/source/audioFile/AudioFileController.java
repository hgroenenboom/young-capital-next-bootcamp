package com.harold.app.source.audioFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//View: Endpoint: Officieel dus view, maar genereert vaak geen HTML! = connectie van frontend to backend.
@Controller
@RequestMapping(path="/audiofile")
public class AudioFileController {
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

