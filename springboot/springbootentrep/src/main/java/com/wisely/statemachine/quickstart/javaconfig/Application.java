//package com.wisely.statemachine.quickstart.javaconfig;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.statemachine.StateMachine;
//import com.wisely.statemachine.quickstart.Events;
//import com.wisely.statemachine.quickstart.States;
//
//@SpringBootApplication
//public class Application implements CommandLineRunner{
//	
//	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//	}
//
//	@Autowired
//	StateMachine<States, Events> stateMachine;
//
////	void doSignals() {
////		stateMachine.start();
////		stateMachine.sendEvent(Events.EVENT1);
////		stateMachine.sendEvent(Events.EVENT2);
////	}
//
//	@Override
//	public void run(String... arg0) throws Exception {
//		stateMachine.start();
//		stateMachine.sendEvent(Events.EVENT1);
//		stateMachine.sendEvent(Events.EVENT2);
//	}
//}
