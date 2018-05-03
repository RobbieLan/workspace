package com.sample;

import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.builder.model.KieSessionModel;
import org.kie.api.conf.EqualityBehaviorOption;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.conf.ClockTypeOption;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

//	public static final void main(String[] args) {
//		try { // load up the knowledge base
//			KieServices ks = KieServices.Factory.get();
//			KieContainer kContainer = ks.getKieClasspathContainer();
//			KieSession kSession = kContainer.newKieSession("ksession-rules");
//
//			// go !
//			Message message = new Message();
//			message.setMessage("Hello World");
//			message.setStatus(Message.HELLO);
//			kSession.insert(message);
//			kSession.fireAllRules();
//		} catch (Throwable t) {
//			t.printStackTrace();
//		}
//	}

	/*
	 * public static void main(String[] args) { KieServices kieServices =
	 * KieServices.Factory.get(); KieModuleModel kieModuleModel =
	 * kieServices.newKieModuleModel();
	 * 
	 * KieBaseModel kieBaseModel1 =
	 * kieModuleModel.newKieBaseModel("KBase1 ").setDefault(true)
	 * .setEqualsBehavior(EqualityBehaviorOption.EQUALITY)
	 * .setEventProcessingMode(EventProcessingOption.STREAM);
	 * 
	 * KieSessionModel ksessionModel1 =
	 * kieBaseModel1.newKieSessionModel("KSession1").setDefault(true)
	 * .setType(KieSessionModel.KieSessionType.STATEFUL).setClockType(
	 * ClockTypeOption.get("realtime"));
	 * 
	 * KieFileSystem kfs = kieServices.newKieFileSystem();
	 * kfs.writeKModuleXML(kieModuleModel.toXML());
	 * 
	 * kfs.write( "src/main/resources/rules/Sample.drl", stringContainingAValidDRL
	 * );//>>??? }
	 */

	public static class Message {

		public static final int HELLO = 0;
		public static final int GOODBYE = 1;

		private String message;

		private int status;

		public String getMessage() {
			return this.message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public int getStatus() {
			return this.status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

	}

}
