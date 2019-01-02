package com.springboot.controller;

import java.time.Duration;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.springboot.model.Student;

import reactor.core.publisher.Flux;

@Service
public class ConsumerService {

	private WebClient webClient = WebClient.create("http://localhost:9001");

	public Flux<Student> fetchStudents() {
		return webClient.get().uri("/student/all").retrieve().bodyToFlux(Student.class)
				.delayElements(Duration.ofSeconds(1));
	}
}
