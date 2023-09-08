package com.ipsator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
	
	Logger log=LoggerFactory.getLogger(LoggingController.class);
	@GetMapping("/welcome")
	public ResponseEntity<String> getLog(){
		log.trace("This is the trace msg");
		log.debug("This is the debug msg");
		log.info("This is the Info msg");
		log.warn("This is the warning msg");
		log.error("This is the Error msg");
		return new ResponseEntity<String>("Logging Practice",HttpStatus.OK);
	}

}
