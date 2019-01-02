package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
	
	@GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Student> fetchStudents(){
		return consumerService.fetchStudents();
	}

}
