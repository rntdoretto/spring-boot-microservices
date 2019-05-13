package com.renatodoretto.examples.microservices.core.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.renatodoretto.examples.microservices.core.model.Price;

public interface PriceRepository extends PagingAndSortingRepository<Price, Long>{

}
