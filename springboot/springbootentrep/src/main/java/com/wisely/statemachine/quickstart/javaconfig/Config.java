package com.wisely.statemachine.quickstart.javaconfig;

import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import com.wisely.statemachine.quickstart.Events;
import com.wisely.statemachine.quickstart.States;

@Configuration
@EnableStateMachine
public class Config extends EnumStateMachineConfigurerAdapter<States, Events> {

	@Override
	public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
		states.withStates().initial(States.STATE1).states(EnumSet.allOf(States.class));
	}

	@Override
	public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
		transitions.withExternal().source(States.STATE1).target(States.STATE2).event(Events.EVENT1).and()
				.withExternal().source(States.STATE2).target(States.STATE1).event(Events.EVENT2);
	}
}
