package com.bridgelabz.fundoonotes.configaration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bridgelabz.fundoonotes.utility.Utility;

@Configuration
public class ApplicationConfig {

	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
	
	@Bean
	public Utility getUtility() {
		return new Utility();
	}
	
}
