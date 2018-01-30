package com.wisely;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

import com.wisely.statemachine.quickstart.Events;
import com.wisely.statemachine.quickstart.States;

@SpringBootApplication
public class Ch91Application {
	
	@Autowired
	StateMachine<States, Events> stateMachine;
	
	public static void main(String[] args) {
		SpringApplication.run(Ch91Application.class, args);
	}
}
