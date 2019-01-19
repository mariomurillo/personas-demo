package com.example.users.repository.impl;

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
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.example.users.model.Person;
import com.example.users.repository.SpringDataPersonRepository;

/**
 * The Class PersonRepositoryImplMockTest.
 *
 * @author mario.murillo
 */
public class PersonRepositoryImplMockTest {

	/** The person repository. */
	private PersonRepositoryImpl personRepository;

	/** The spring data repository. */
	private SpringDataPersonRepository springDataRepository;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {

		springDataRepository = mock(SpringDataPersonRepository.class);

		personRepository = new PersonRepositoryImpl(springDataRepository);
	}

	/**
	 * Test case for save a person.
	 */
	@Test
	public void saveTest() {

		reset(springDataRepository);

		final Person person = new Person();
		person.setId(1l);

		when(springDataRepository.save(any())).thenReturn(person);

		final Person personSaved = personRepository.save(new Person());

		assertNotNull(personSaved);
		assertNotNull(personSaved.getId());
		assertEquals(1l, personSaved.getId().longValue());
		assertEquals(person, personSaved);

		verify(springDataRepository).save(any());
	}

	/**
	 * Test case for save with null test.
	 */
	@Test(expected = NullPointerException.class)
	public void saveWithNullTest() {

		reset(springDataRepository);

		final Person person = new Person();
		person.setId(1l);

		when(springDataRepository.save(null)).thenThrow(NullPointerException.class);

		personRepository.save(null);
	}

	/**
	 * Test case for find all persons.
	 */
	@Test
	public void findAllTest() {

		reset(springDataRepository);

		final Person person = new Person();
		person.setId(1l);

		when(springDataRepository.findAll()).thenReturn(Arrays.asList(person));

		final List<Person> personsFound = personRepository.findAll();

		assertNotNull(personsFound);
		assertFalse(personsFound.isEmpty());
		assertNotNull(personsFound.get(0));
		assertNotNull(personsFound.get(0).getId());
		assertEquals(1l, personsFound.get(0).getId().longValue());
		assertEquals(person, personsFound.get(0));

		verify(springDataRepository).findAll();
	}

	/**
	 * Test case for find by id.
	 */
	@Test
	public void findByIdTest() {

		reset(springDataRepository);

		final Person person = new Person();
		person.setId(1l);

		when(springDataRepository.findById(anyLong())).thenReturn(Optional.of(person));

		final Person personFound = personRepository.findById(1l);

		assertNotNull(personFound);
		assertNotNull(personFound.getId());
		assertEquals(1l, personFound.getId().longValue());
		assertEquals(person, personFound);

		verify(springDataRepository).findById(anyLong());
	}

	/**
	 * Test case for find by id without result.
	 */
	@Test
	public void findByIdWithoutResultTest() {

		reset(springDataRepository);

		when(springDataRepository.findById(anyLong())).thenReturn(Optional.empty());

		final Person personFound = personRepository.findById(1l);

		assertNull(personFound);

		verify(springDataRepository).findById(anyLong());
	}

	/**
	 * Test case for delete a person.
	 */
	@Test
	public void deleteTest() {

		reset(springDataRepository);

		final Person person = new Person();
		person.setId(1l);

		personRepository.delete(person);

		verify(springDataRepository).delete(any());
	}
}
