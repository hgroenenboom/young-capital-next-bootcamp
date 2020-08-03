package com.harold.app.source.audioFile;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Controller -> CRUD operations (automatisch). Eerste laag op DB
@Repository
//interface AudioFileRepository extends CrudRepository<AudioFile, Integer> {	  // This is not a JPA repository, so it doesn't support automatic method names.
public interface AudioFileRepository extends JpaRepository<AudioFile, Integer> {	 
	List<AudioFile> findByAddedDateBefore(LocalDateTime time);
}
