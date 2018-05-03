package com.wisely.person.controller;

import java.time.LocalDateTime;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.person.dao.PersonRepository;
import com.wisely.person.domain.Person;

import io.swagger.annotations.ApiOperation;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    
    @ApiOperation(httpMethod="POST",value="保存用户",notes="自定义附加说明")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void savePerson(@RequestBody String  personName, HttpServletRequest request, HttpServletResponse response) {
    	String var=request.getServletPath();
    	String var2=request.getMethod().getClass().getName();
//    	String var2=request.getreal];
    	System.out.println("--------------pathinfo-----"+var+"----------"+var2);
    	Person p = new Person(personName);
//    	p=null;
//    	p.getName();
    	personRepository.save(p);
    	List<Person> people = personRepository.findAll(new PageRequest(0, 10)).getContent();
    	try {
			response.getWriter().print("错误");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("--------------after response.getWriter.print");
//        return people;
    }
    
    @ApiOperation(httpMethod="GET",value="日期测试",notes="日期测试")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public void getPerson(@RequestParam (value="date1", required=false)Date date1,
    		@RequestParam (value="date2", required=false)LocalDateTime date2) {
    	int a=1+1;
    	int b=a++;
    }

}
