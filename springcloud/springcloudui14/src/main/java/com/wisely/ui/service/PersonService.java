package com.wisely.ui.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisely.ui.domain.Person;

@FeignClient("person")
public interface PersonService {
	 @RequestMapping(method = RequestMethod.POST, value = "/save",
	            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody List<Person> save(@RequestBody String  name);
	 
	 @RequestMapping(value = "/get", method = RequestMethod.GET)
	 @ResponseBody
	 public void get(@RequestParam (value="date1", required=false)LocalDateTime date1,
	    		@RequestParam (value="date2", required=false)Date date2);
}
