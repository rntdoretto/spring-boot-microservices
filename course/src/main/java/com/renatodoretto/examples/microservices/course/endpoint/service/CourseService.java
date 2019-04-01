package com.renatodoretto.examples.microservices.course.endpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.renatodoretto.examples.microservices.core.model.Course;
import com.renatodoretto.examples.microservices.core.repository.CourseRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class CourseService {
	private final CourseRepository courseRepository;
	
	public Iterable<Course> list (Pageable pageable) {
		log.info("log");
		return courseRepository.findAll(pageable);
	}

}
