package com.harold.app.source.audioFileData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioFileDataRepository extends JpaRepository<AudioFileData, Integer> {

}
