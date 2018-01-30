package com.wisely.statemachine.reference.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineModelConfigurer;
import org.springframework.statemachine.config.model.StateMachineModelFactory;
import org.springframework.statemachine.uml.UmlStateMachineModelFactory;


@Configuration
@EnableStateMachine
public class Config1 extends StateMachineConfigurerAdapter<String, String> {
	
	@Override
	public void configure(StateMachineModelConfigurer<String, String> model) throws Exception {
		model.withModel().factory(modelFactory());
	}

	@Bean
	public StateMachineModelFactory<String, String> modelFactory() {
		return new UmlStateMachineModelFactory(
				"classpath:simple-machine.uml");
	}
}
