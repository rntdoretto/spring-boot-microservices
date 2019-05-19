package com.renatodoretto.examples.microservices.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.renatodoretto.examples.microservices.currencyexchange.model.ExchangeValue;
import com.renatodoretto.examples.microservices.currencyexchange.service.ExchangeValueService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor_ = { @Autowired })
@RestController
public class CurrencyExchangeController {

	private final Environment environment;
	private final ExchangeValueService exchangeValueService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
		ExchangeValue exchangeValue = exchangeValueService.findExchangeValueByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
