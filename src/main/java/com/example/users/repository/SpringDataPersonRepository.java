package com.example.users.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.users.model.Person;

/**
 * The Interface SpringDataPersonRepository.
 *
 * @author mario.murillo
 */
public interface SpringDataPersonRepository extends CrudRepository<Person, Long> {

}
