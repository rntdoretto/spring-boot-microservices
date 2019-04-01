package com.renatodoretto.examples.microservices.core.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.renatodoretto.examples.microservices.core.model.Course;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long>{
	
}
