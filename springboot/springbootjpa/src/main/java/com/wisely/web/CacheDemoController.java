package com.wisely.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.domain.Person;
import com.wisely.service.CacheDemoService;
@RestController
public class CacheDemoController {
	@Autowired
	CacheDemoService demoService;

	@RequestMapping("/put")
	public Person put(Person person) {
		return demoService.save(person);

	}

	@RequestMapping("/able")
	public Person cacheable(Person person) {

		return demoService.findOne(person);

	}

	@RequestMapping("/evit")
	public String evit(Long id) {
		demoService.remove(id);
		return "ok";

	}
}
