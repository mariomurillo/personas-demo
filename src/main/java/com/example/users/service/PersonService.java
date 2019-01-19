package com.example.users.service;

import java.util.List;

import com.example.users.model.Person;

/**
 * The Interface PersonService.
 *
 * @author mario.murillo
 */
public interface PersonService {

	/**
	 * Creates a person.
	 *
	 * @param person the person
	 * @return the person to create
	 */
	Person create(Person person);

	/**
	 * Find all persons.
	 *
	 * @return the list of the persons found
	 */
	List<Person> findAll();

	/**
	 * Update a person.
	 *
	 * @param person the person
	 * @return the person updated
	 */
	Person update(Person person);

	/**
	 * Delete a person.
	 *
	 * @param id the id person to delete
	 */
	void delete(Long id);
}
