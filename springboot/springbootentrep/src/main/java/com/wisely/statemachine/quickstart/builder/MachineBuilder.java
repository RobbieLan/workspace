package com.wisely.statemachine.quickstart.builder;

import java.util.EnumSet;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.StateMachineBuilder.Builder;

import com.wisely.statemachine.quickstart.Events;
import com.wisely.statemachine.quickstart.States;

public class MachineBuilder {
	public StateMachine<States, Events> buildMachine() throws Exception {
	    Builder<States, Events> builder = StateMachineBuilder.builder();

	    builder.configureStates()
	        .withStates()
	            .initial(States.STATE1)
	            .states(EnumSet.allOf(States.class));

	    builder.configureTransitions()
	        .withExternal()
	            .source(States.STATE1).target(States.STATE2)
	            .event(Events.EVENT1)
	            .and()
	        .withExternal()
	            .source(States.STATE2).target(States.STATE1)
	            .event(Events.EVENT2);

	    return builder.build();
	}
}
