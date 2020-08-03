package com.harold.app.source.audioFileData;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("audiofiledata")
@RestController
public class AudioFileDataController {
	@GetMapping(path="/test")
	String log() {
		System.out.println("test callable");
		return "test";
	}
}
