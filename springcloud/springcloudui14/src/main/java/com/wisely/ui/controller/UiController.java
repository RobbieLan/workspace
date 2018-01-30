package com.wisely.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.ui.domain.Person;
import com.wisely.ui.service.PersonHystrixService;
//import com.wisely.ui.service.SomeHystrixService;
import com.wisely.ui.service.hims.PersonRemoteService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UiController {
//	@Autowired
//	private SomeHystrixService someHystrixService;
	
	@Autowired
	private PersonHystrixService personHystrixService;
	
	@Autowired
	private PersonRemoteService personRemtoService;
	
	@ApiOperation(httpMethod="POST",value="保存用户",notes="自定义补充说明")
	@RequestMapping("/dispatch")
	public List<Person> sendMessage(@RequestBody String personName) {
//		return personHystrixService.save(personName);
		return personRemtoService.save(personName);
	}
	
//	@RequestMapping(value = "/getsome",produces={MediaType.TEXT_PLAIN_VALUE})
//	public String getSome(){
//		return someHystrixService.getSome();
//	}
}
