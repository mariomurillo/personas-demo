package com.example.users.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.constant.MessageType;
import com.example.users.dto.PersonDto;
import com.example.users.model.Person;
import com.example.users.response.PersonResponse;
import com.example.users.service.PersonService;

/**
 * The Class PersonController.
 *
 * @author mario.murillo
 */
@RestController
@RequestMapping("/personas")
public class PersonController {

	/** The person service. */
	private final PersonService service;

	/** The converter. */
	private final DefaultConversionService converter;

	/**
	 * Instantiates a new person controller.
	 *
	 * @param service   the service
	 * @param converter the converter
	 */
	public PersonController(final PersonService service, final DefaultConversionService converter) {
		this.service = service;
		this.converter = converter;
	}

	/**
	 * Create a person.
	 *
	 * @param person the person to create
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<PersonResponse> create(@RequestBody final PersonDto person) {

		final Person personCreated = service.create(converter.convert(person, Person.class));

		if (personCreated != null) {

			return new ResponseEntity<>(getResponse(MessageType.CREATE, personCreated.getId().toString()),
					HttpStatus.CREATED);
		} else {

			return new ResponseEntity<>(getResponse(MessageType.CREATE, null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Find all.
	 *
	 * @return the response entity
	 */
	@GetMapping
	public ResponseEntity<List<Person>> findAll() {

		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	/**
	 * Update.
	 *
	 * @param id     the id
	 * @param person the person
	 * @return the response entity
	 */
	@PutMapping("/{id}")
	public ResponseEntity<PersonResponse> update(@PathVariable final Long id, @RequestBody final PersonDto person) {

		try {
			final Person personConverted = converter.convert(person, Person.class);
			personConverted.setId(id);

			final Person personUpdated = service.update(personConverted);

			return new ResponseEntity<>(getResponse(MessageType.UPDATE, personUpdated.getId().toString()),
					HttpStatus.OK);
		} catch (final IllegalArgumentException e) {
			return new ResponseEntity<>(getResponse(MessageType.UPDATE, null),
					HttpStatus.BAD_REQUEST);
		} catch (final NoSuchElementException e) {
			return new ResponseEntity<>(getResponse(MessageType.UPDATE, id.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<PersonResponse> delete(@PathVariable final Long id) {

		try {
			service.delete(id);

			return new ResponseEntity<>(getResponse(MessageType.DELETE, id.toString()), HttpStatus.OK);
		} catch (final IllegalArgumentException e) {
			return new ResponseEntity<>(getResponse(MessageType.DELETE, null), HttpStatus.BAD_REQUEST);
		} catch (final NoSuchElementException e) {
			return new ResponseEntity<>(getResponse(MessageType.UPDATE, id.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Gets the response.
	 *
	 * @param messageType the message type
	 * @param id          the id of the person
	 * @return the response
	 */
	private PersonResponse getResponse(final MessageType messageType, final String id) {

		PersonResponse response = null;

		switch (messageType) {
		case CREATE:

			if (id != null) {
				response = new PersonResponse("Persona creada exitosamente", id);
			} else {
				response = new PersonResponse("Ocurrio un error mientras se creaba la persona", id);
			}
			break;

		case UPDATE:

			if (id != null) {
				response = new PersonResponse("Persona actualizada exitosamente", id);
			} else {
				response = new PersonResponse("Ocurrio un error mientras se actualizaba la persona", id);
			}
			break;

		case DELETE:

			if (id != null) {
				response = new PersonResponse("Persona eliminada exitosamente", id);
			} else {
				response = new PersonResponse("Ocurrio un error mientras se eliminaba la persona", id);
			}
			break;

		default:
			break;
		}
		return response;
	}
}
