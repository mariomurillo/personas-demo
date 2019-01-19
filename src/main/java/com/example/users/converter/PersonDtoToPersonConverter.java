package com.example.users.converter;

import org.springframework.core.convert.converter.Converter;

import com.example.users.dto.PersonDto;
import com.example.users.model.Person;

/**
 * The Class PersonDtoToPersonConverter.
 *
 * @author mario.murillo
 */
public class PersonDtoToPersonConverter implements Converter<PersonDto, Person> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Person convert(final PersonDto source) {

		Person target = null;

		if (source != null) {

			target = new Person();

			if (source.getCedula() != null) {
				target.setIdentifyNumber(source.getCedula());
			}
			if (source.getNombre() != null) {
				target.setName(source.getNombre());
			}
		}
		return target;
	}
}
