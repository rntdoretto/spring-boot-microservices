package com.renatodoretto.examples.microservices.currencyconversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.renatodoretto.examples.microservices.currencyconversion.model.CurrencyConversion;
import com.renatodoretto.examples.microservices.currencyconversion.proxy.CurrencyExchangeProxy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor_ = { @Autowired })
@RestController
public class CurrencyConversionController {

	private final CurrencyExchangeProxy currencyExchangeProxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {

		// Feign - Problem 1
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		CurrencyConversion response = responseEntity.getBody();

		return new CurrencyConversion(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrencyFeign(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {
		CurrencyConversion response = currencyExchangeProxy.retrieveExchangeValue(from, to);
		return new CurrencyConversion(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
}
