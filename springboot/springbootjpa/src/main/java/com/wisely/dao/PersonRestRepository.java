package com.wisely.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.wisely.domain.Person;
/*
 * Test Spring DATA Rest
 * */
@RepositoryRestResource(path = "people") //This annotation is not obligatory, while doing so we can define the rest path other than the default one which is 'entity+s'
public interface PersonRestRepository extends JpaRepository<Person, Long> {
	
	@RestResource(path = "nameStartsWith", rel = "nameStartsWith")//Expose as rest service
	Person findByNameStartsWith(@Param("name")String name);

}
