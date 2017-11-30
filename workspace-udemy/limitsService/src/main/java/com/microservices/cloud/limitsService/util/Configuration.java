package com.microservices.cloud.limitsService.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limitsservice")
public class Configuration {

	private Integer minimum;
	private Integer maxmum;

	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	public Integer getMaxmum() {
		return maxmum;
	}

	public void setMaxmum(Integer maxmum) {
		this.maxmum = maxmum;
	}

}
