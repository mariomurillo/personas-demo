package com.example.users.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Class PersonResponse.
 *
 * @author mario.murillo
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "cedula", "nombre" })
public class PersonResponse {

	/** The message. */
	@JsonProperty("message")
	private String message;

	/** The id. */
	@JsonProperty("id")
	private String id;

	/**
	 * Instantiates a new person response.
	 *
	 * @param message the message
	 * @param id      the id
	 */
	public PersonResponse(final String message, final String id) {
		this.message = message;
		this.id = id;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}
}
