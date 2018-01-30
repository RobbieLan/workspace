package com.wisely.service;

import com.wisely.domain.Person;

public interface CacheDemoService {
	public Person save(Person person);
	
	public void remove(Long id);
	
	public Person findOne(Person person);
}
