package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;
import com.springboot.repository.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@PostConstruct
	public void loadStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(12345, "john", 12));
		students.add(new Student(12365, "james", 14));
		students.add(new Student(12346, "mary", 15));
		students.add(new Student(12347, "sam", 11));
		students.add(new Student(12348, "mark", 10));
		students.add(new Student(12349, "jack", 16));
		studentRepository.saveAll(students);
	}

	@GetMapping("/filter/byId/{id}")
	public Mono<Student> getStudentById(@PathVariable int id) {
		return studentRepository.findById(id);
	}

	@GetMapping("/all")
	public Flux<Student> getAllStudentDetails() {
		return studentRepository.findAll();
	}

	@GetMapping("/filter/byAge/{age}")
	public Flux<Student> getStudentByAgeGreaterThan(@PathVariable int age) {
		return studentRepository.findByAgeGreaterThan(age);
	}
}
