package com.renatodoretto.examples.microservices.currencyexchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatodoretto.examples.microservices.currencyexchange.model.ExchangeValue;
import com.renatodoretto.examples.microservices.currencyexchange.repository.ExchangeValueRepository;
import com.renatodoretto.examples.microservices.currencyexchange.service.ExchangeValueService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class ExchangeValueServiceImpl implements ExchangeValueService{
	
	private final ExchangeValueRepository exchangeValueRepository;

	@Override
	public ExchangeValue findExchangeValueByFromAndTo(String from, String to) {
		return exchangeValueRepository.findByFromAndTo(from, to);
	}

}
