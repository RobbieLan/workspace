package com.wisely.ui.service.hims.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wisely.ui.domain.Person;
import com.wisely.ui.service.hims.PersonRemoteService;

@Component
public class PersonRemoteServiceHystrix implements PersonRemoteService{

	@Override
	public List<Person> save(String name) {
		List<Person> list = new ArrayList<>();
		Person p = new Person(name+"没有保存成功，Person Service 故障");
		list.add(p);
		return list;
	}

}
