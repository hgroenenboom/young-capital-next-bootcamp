package com.harold.app.source.audioFile;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

//Controller -> Laag op de CRUD operations, CRUD is basaal.
@Service
@Transactional // what does this do?
public class AudioFileService { 
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
