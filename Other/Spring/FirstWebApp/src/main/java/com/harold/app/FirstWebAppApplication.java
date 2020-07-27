package com.harold.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = JpaRepositoriesAutoConfiguration.class) // If JPARepositories are not yet created, otherwise autoconfigurator generates error.
//@EnableScheduling // For scheduling test
//@ComponentScan
public class FirstWebAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FirstWebAppApplication.class, args);
	}
	

}

/*
@RestController
class testRest {
	// maps localhost:$(PORT)/hello to below hello(...) function
	@GetMapping(path="/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
*/
