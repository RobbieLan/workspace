/**
 * 
 */
package com.mock.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zhailiang
 *	Interceptor is advanced than filter in a way that we can get method info from Object handler,
 *	yet we can't get param values. AOP can get param values, but can't get httpRequest/Response.
 */
@Aspect
@Component
public class TimeAspect {
	
	@Around("execution(* com.mock.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("time aspect start");
		
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			System.out.println("arg is "+arg);
		}
		
		long start = new Date().getTime();
		// just like chain.doFilter(request,response)
		// object stands for the result that a method in controller returns!
		Object object = pjp.proceed();
		
		System.out.println("time aspect 耗时:"+ (new Date().getTime() - start));
		
		System.out.println("time aspect end");
		
		return object;
	}

}
