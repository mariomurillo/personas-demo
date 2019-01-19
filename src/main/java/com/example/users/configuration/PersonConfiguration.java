package com.example.users.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;

import com.example.users.converter.PersonDtoToPersonConverter;

/**
 * The Class PersonConfiguration.
 *
 * @author mario.murillo
 */
@Configuration
public class PersonConfiguration {

	/**
	 * Default conversion service.
	 *
	 * @return the default conversion service
	 */
	@Bean
	public DefaultConversionService defaultConversionService() {

		final DefaultConversionService defaultConversionService = new DefaultConversionService();
		defaultConversionService.addConverter(new PersonDtoToPersonConverter());

		return defaultConversionService;
	}
}
