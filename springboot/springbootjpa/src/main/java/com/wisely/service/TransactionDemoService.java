package com.wisely.service;

import com.wisely.domain.Person;

public interface TransactionDemoService {
	public Person savePersonWithRollBack(Person person);
	public Person savePersonWithoutRollBack(Person person);
}
