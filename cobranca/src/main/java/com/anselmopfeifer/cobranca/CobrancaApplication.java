package com.anselmopfeifer.cobranca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@SpringBootApplication
public class CobrancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CobrancaApplication.class, args);
	}
	
	@Configuration
	public static class MvcConfig extends WebMvcAutoConfigurationAdapter{
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/titulos");
		}
	}
}
