package com.example.users.repository;

import java.util.List;

import com.example.users.model.Person;

/**
 * The Interface PersonRepository.
 *
 * @author mario.murillo
 */
public interface PersonRepository {

	/**
	 * Save a person.
	 *
	 * @param person the person
	 * @return the person saved
	 */
	Person save(Person person);

	/**
	 * Find all persons.
	 *
	 * @return the list of the persons
	 */
	List<Person> findAll();

	/**
	 * Find person by id.
	 *
	 * @param id the id of the person
	 * @return the person found
	 */
	Person findById(Long id);

	/**
	 * Delete a person.
	 *
	 * @param person the person
	 */
	void delete(Person person);
}
