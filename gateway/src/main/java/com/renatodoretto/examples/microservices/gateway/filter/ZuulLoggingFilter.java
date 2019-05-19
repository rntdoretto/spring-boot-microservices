package com.renatodoretto.examples.microservices.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		log.info("request -> {} request uri -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return "pre"; // pre / post / error
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
