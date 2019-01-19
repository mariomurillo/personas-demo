package com.example.users.repository.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.users.model.Person;
import com.example.users.repository.PersonRepository;
import com.example.users.repository.SpringDataPersonRepository;

/**
 * The Class PersonRepositoryImpl.
 *
 * @author mario.murillo
 */
@Component
public class PersonRepositoryImpl implements PersonRepository {

	/** The spring data person repository. */
	private final SpringDataPersonRepository springDataRepository;

	/**
	 * Instantiates a new person repository.
	 *
	 * @param springDataRepository the spring data person repository
	 */
	public PersonRepositoryImpl(final SpringDataPersonRepository springDataRepository) {
		this.springDataRepository = springDataRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Person save(final Person person) {
		return springDataRepository.save(person);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Person> findAll() {
		return (List<Person>) springDataRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Person findById(final Long id) {
		return springDataRepository.findById(id).orElse(null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(final Person person) {
		springDataRepository.delete(person);
	}
}
