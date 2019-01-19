package com.example.users.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import com.example.users.model.Person;
import com.example.users.repository.PersonRepository;

/**
 * The Class PersonServiceImplMockTest.
 *
 * @author mario.murillo
 */
public class PersonServiceImplMockTest {

	/** The person service. */
	private PersonServiceImpl personService;

	/** The person repository. */
	private PersonRepository repository;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {

		repository = mock(PersonRepository.class);

		personService = new PersonServiceImpl(repository);
	}

	/**
	 * Test case for create a person.
	 */
	@Test
	public void createTest() {

		reset(repository);

		final Person person = new Person();
		person.setId(1l);

		when(repository.save(any())).thenReturn(person);

		final Person personCreated = personService.create(new Person());

		assertNotNull(personCreated);
		assertNotNull(personCreated.getId());
		assertEquals(1l, personCreated.getId().longValue());
		assertEquals(person, personCreated);

		verify(repository).save(any());
	}

	/**
	 * Test case for create a person with null.
	 */
	@Test
	public void createWithNullTest() {

		final Person personCreated = personService.create(new Person());

		assertNull(personCreated);
	}

	/**
	 * Test case for find all persons.
	 */
	@Test
	public void findAllTest() {

		reset(repository);

		final Person person = new Person();
		person.setId(1l);

		when(repository.findAll()).thenReturn(Arrays.asList(person));

		final List<Person> personsFound = personService.findAll();

		assertNotNull(personsFound);
		assertFalse(personsFound.isEmpty());
		assertNotNull(personsFound.get(0));
		assertNotNull(personsFound.get(0).getId());
		assertEquals(1l, personsFound.get(0).getId().longValue());

		verify(repository).findAll();
	}

	/**
	 * Test case for update a person.
	 */
	@Test
	public void updateTest() {

		reset(repository);

		final Person person = new Person();
		person.setId(1l);

		final Person person2 = new Person();
		person2.setId(1l);

		when(repository.findById(anyLong())).thenReturn(person);
		when(repository.save(any())).thenReturn(person);

		final Person personUpdate = personService.update(person2);

		assertNotNull(personUpdate);
		assertNotNull(personUpdate.getId());
		assertEquals(1l, personUpdate.getId().longValue());
		assertEquals(person, personUpdate);

		verify(repository).save(any());
		verify(repository).findById(anyLong());
	}

	/**
	 * Test case for update a person with null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void updateWithNullTest() {
		personService.update(null);
	}

	/**
	 * Test case for update a person with id null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void updateWithIdNullTest() {
		personService.update(new Person());
	}

	/**
	 * Test case for update when not exist person.
	 */
	@Test(expected = NoSuchElementException.class)
	public void updateWhenNotExistPersonTest() {

		reset(repository);

		final Person person = new Person();
		person.setId(1l);

		when(repository.findById(anyLong())).thenReturn(null);

		personService.update(person);
	}

	/**
	 * Test case for delete a person.
	 */
	@Test
	public void deleteTest() {

		reset(repository);

		final Person person = new Person();
		person.setId(1l);

		when(repository.findById(anyLong())).thenReturn(person);

		personService.delete(1l);

		verify(repository).delete(any());
		verify(repository).findById(anyLong());
	}

	/**
	 * Test case for delete when not exist person.
	 */
	@Test(expected = NoSuchElementException.class)
	public void deleteWhenNotExistPersonTest() {

		reset(repository);

		final Person person = new Person();
		person.setId(1l);

		when(repository.findById(anyLong())).thenReturn(null);

		personService.delete(1l);
	}

	/**
	 * Test case for delete whith id null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void deleteWhithIdNullTest() {
		personService.delete(null);
	}
}
