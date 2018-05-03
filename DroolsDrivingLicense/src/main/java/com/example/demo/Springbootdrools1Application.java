package com.example.demo;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;  

//@SpringBootApplication
public class Springbootdrools1Application {

	public static void main(String[] args) {
		// SpringApplication.run(Springbootdrools1Application.class, args);
		
			KieServices ks = KieServices.Factory.get();
			ReleaseId id=ks.newReleaseId("com.hers", "herstory", "1.2");
			KieContainer kieContainer = ks.newKieContainer(id);
			KieSession kieSession = kieContainer.newKieSession();
			
			FactType factType = factType(kieContainer.getKieBase());
			Object fact=null;
			try {
				fact = makeApplicant(factType);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			kieSession.insert(fact);
			kieSession.fireAllRules();
			
			Boolean b=(Boolean) factType.get(fact, "valid");
//			System.out.println("fact:  "+fact.toString());
			System.out.println("fact:  "+b);
	}
			
			
//		ReleaseIdImpl releaseId = new ReleaseIdImpl("com.hms", "driving-license", "1.0");
//		KieServices ks = KieServices.Factory.get();
//		KieContainer container = ks.newKieContainer(releaseI\d);
//		KieScanner scanner = ks.newKieScanner(container);
//		scanner.start(1000);
//		StatelessKieSession session = container.newStatelessKieSession();
//
//		for (int i = 0; i < 100; i++) {
//			try {
//				FactType factType = factType(container.getKieBase());
//				Object applicant = makeApplicant(factType);
//				session.execute(applicant);
//				System.out.println("申请人：" + factType.get(applicant, "name") + "，年龄：" + factType.get(applicant, "age")
//				+ "是否可以申请驾照" + factType.get(applicant, "valid"));
//				
//				Thread.sleep(20000);// 休眠20秒，等待更新规则查看输出结果
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}

	private static Object makeApplicant(FactType factType) throws Exception {
		Object fact = factType.newInstance();
		factType.set(fact, "age", 20);
		return fact;
	}

	protected static FactType factType(KieBase base) {
		FactType factType = base.getFactType("com.hers.herstory", "Person");
		return factType;
	}
}
