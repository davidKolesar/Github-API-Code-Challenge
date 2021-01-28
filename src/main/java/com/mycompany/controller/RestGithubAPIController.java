package com.mycompany.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestGithubAPIController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));

		// take json response and convert it into object. each id is unique object

	}

	// all for new york:
	// https://jobs.github.com/positions.json?description=&location=new+york

	// python in new york:
	// https://jobs.github.com/positions.json?description=python&location=new+york

	public void summarizeData() {
		//take json object and populate a POJO
		
//		for(javaObject : x) {
		
			//new JobSummaryObject
			//
	}
	
	}

}
