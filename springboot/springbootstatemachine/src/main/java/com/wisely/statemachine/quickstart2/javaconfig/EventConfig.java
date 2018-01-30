package com.wisely.statemachine.quickstart2.javaconfig;

import org.apache.log4j.Logger;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class EventConfig {
	Logger log=Logger.getLogger(EventConfig.class);
	
	@OnTransition(target = "STATE1")
	public void toState1() {
		log.info("On Transition to STATE1");
	}

	@OnTransition(target = "STATE2")
	public void toState2() {
		log.info("On Transition to STATE1");
	}
}
