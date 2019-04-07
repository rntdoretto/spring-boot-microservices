package com.renatodoretto.examples.microservices.core.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.renatodoretto.examples.microservices.core.model.ApplicationUser;

public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long>{
	
	public ApplicationUser findByUsername(String username);
	
}
