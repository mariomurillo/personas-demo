package com.example.users.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Person.
 *
 * @author mario.murillo
 */
@Entity
@Table(name = "persona")
public class Person implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	/** The identify number. */
	@Column(name = "cedula")
	private String identifyNumber;

	/** The name. */
	@Column(name = "nombre")
	private String name;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the identifyNumber
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}

	/**
	 * @param identifyNumber the identifyNumber to set
	 */
	public void setIdentifyNumber(final String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
}
