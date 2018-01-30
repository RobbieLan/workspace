package com.wisely.statemachine.quickstart.javaconfig;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class EventConfig {
	 @OnTransition(target = "STATE1")
	    void toState1() {
	    }

	    @OnTransition(target = "STATE2")
	    void toState2() {
	    }
}
