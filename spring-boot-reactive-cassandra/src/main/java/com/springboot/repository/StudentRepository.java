package com.springboot.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Student;

import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveCassandraRepository<Student, Integer> {
	
	@AllowFiltering
	Flux<Student> findByAgeGreaterThan(int age);

}
