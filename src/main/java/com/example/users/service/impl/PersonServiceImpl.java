package com.example.users.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.users.model.Person;
import com.example.users.repository.PersonRepository;
import com.example.users.service.PersonService;

/**
 * The Class PersonServiceImpl.
 *
 * @author mario.murillo
 */
@Service
public class PersonServiceImpl implements PersonService {

	/** The person repository. */
	private final PersonRepository repository;

	/**
	 * Instantiates a new person service.
	 *
	 * @param repository the repository
	 */
	public PersonServiceImpl(final PersonRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Person create(final Person person) {

		Person personCreated = null;

		if (person != null) {
			personCreated = repository.save(person);
		}
		return personCreated;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Person> findAll() {
		return repository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Person update(final Person person) {

		Person personUpdated = null;

		if (person != null && person.getId() != null) {

			final Person personFound = repository.findById(person.getId());

			if (personFound != null) {

				updatePersonData(person, personFound);

				personUpdated = repository.save(personFound);
			} else {
				throw new NoSuchElementException();
			}
		} else {
			throw new IllegalArgumentException();
		}
		return personUpdated;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(final Long id) {

		if (id != null) {
			final Person personFound = repository.findById(id);

			if (personFound != null) {
				repository.delete(personFound);
			} else {
				throw new NoSuchElementException();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Update person data.
	 *
	 * @param person      the person
	 * @param personFound the person found
	 */
	private void updatePersonData(final Person person, final Person personFound) {
		if (person.getIdentifyNumber() != null) {
			personFound.setIdentifyNumber(person.getIdentifyNumber());
		}
		if (person.getName() != null) {
			personFound.setName(person.getName());
		}
	}
}
