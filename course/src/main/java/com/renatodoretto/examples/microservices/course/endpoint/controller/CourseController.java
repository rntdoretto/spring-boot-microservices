package com.renatodoretto.examples.microservices.course.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renatodoretto.examples.microservices.core.model.Course;
import com.renatodoretto.examples.microservices.course.endpoint.service.CourseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("v1/admin/courses")
@Slf4j
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class CourseController {	
	private final CourseService courseService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Iterable<Course>> list(Pageable pageable) {
		log.info("list");
		return new ResponseEntity<>(courseService.list(pageable), HttpStatus.OK);
	}
}
