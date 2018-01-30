package com.wisely.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wisely.domain.Person;
import com.wisely.service.TransactionDemoService;

@RestController
public class TransactionDemoController {
	@Autowired
	TransactionDemoService demoService;
	
	@RequestMapping("/rollback")
	public Person rollback(Person person){ //1
		
		return demoService.savePersonWithRollBack(person);
	}
	
	@RequestMapping("/norollback")
	public Person noRollback(Person person){//2
		
		return demoService.savePersonWithoutRollBack(person);
		
		
	}

}
