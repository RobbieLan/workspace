package com.wisely.statemachine.quickstart2.builder;

import java.util.EnumSet;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.StateMachineBuilder.Builder;
import com.wisely.statemachine.quickstart2.Events;
import com.wisely.statemachine.quickstart2.States;
//不好使It doesn't work...
public class MachineBuilder {
	public static StateMachine<States, Events> buildMachine() throws Exception {
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
	public static void main(String[] args) {
		StateMachine<States, Events> stateMachine = null;
		try {
			stateMachine = buildMachine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		stateMachine.start();
		stateMachine.sendEvent(Events.EVENT1);
		stateMachine.sendEvent(Events.EVENT2);
	}
}
