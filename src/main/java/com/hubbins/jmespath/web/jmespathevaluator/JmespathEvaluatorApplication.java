package com.hubbins.jmespath.web.jmespathevaluator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class JmespathEvaluatorApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JmespathEvaluatorApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(JmespathEvaluatorApplication.class, args);
	}
}
