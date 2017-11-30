package com.microservices.cloud.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class);

	@Override
	public Object run() {//The execution
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

		logger.info("request -> {} request uri -> {}", request, request.getRequestURI());

		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;// The fitler should really filter?
	}

	@Override
	public int filterOrder() {
		return 1;// Priority of filter executed
	}

	@Override
	public String filterType() {
		return "pre";// When happen: pre (before), post (after) or error
	}

}
