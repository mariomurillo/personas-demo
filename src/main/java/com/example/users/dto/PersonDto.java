package com.example.users.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Class PersonDto.
 *
 * @author mario.murillo
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "cedula", "nombre" })
public class PersonDto {

	/** The cedula. */
	@JsonProperty("cedula")
	private String cedula;

	/** The nombre. */
	@JsonProperty("nombre")
	private String nombre;

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(final String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
}
