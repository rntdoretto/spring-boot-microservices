package com.renatodoretto.examples.microservices.currencyexchange.service;

import com.renatodoretto.examples.microservices.currencyexchange.model.ExchangeValue;

public interface ExchangeValueService {

	ExchangeValue findExchangeValueByFromAndTo(String from, String to);
}
