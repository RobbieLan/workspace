package com.example.demo;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootdroolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdroolsApplication.class, args);
	}
	
	@RequestMapping(value="/test")
	public void getDrools() {
		System.out.println("test------------------------");
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("declareExampleSession");
			
			
			kSession.fireAllRules();
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
