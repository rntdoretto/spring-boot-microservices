package com.renatodoretto.examples.microservices.currencyconversion.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.renatodoretto.examples.microservices.currencyconversion.model.CurrencyConversion;

@FeignClient(name = "gateway")
@RibbonClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
