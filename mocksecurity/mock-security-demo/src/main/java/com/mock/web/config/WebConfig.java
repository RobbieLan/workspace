/**
 * 
 */
package com.mock.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mock.web.filter.TimeFilter;
import com.mock.web.interceptor.TimeInterceptor;

/**
 * @author zhailiang
 * Register third party filters(as you can't make a change to its code, you can't add @Componenent to enable it), 
 * just the same as in web.xml.
 *
 */
@Configuration
//public class WebConfig{  //WebMvcConfigurerAdapter is necessary for registering interceptors, not filters.
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@SuppressWarnings("unused")
	@Autowired
	private TimeInterceptor timeInterceptor;
	
	//Interrupt Asynchronous request
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//		configurer.registerCallableInterceptors(xxxinterceptor);
//		configurer.registerDeferredResultInterceptors(xxxinterceptors);
//		configurer.setDefaultTimeout(1000);
//		configurer.setTaskExecutor(taskExecutor);
		
	}
	//Interrupt synchronous request
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(timeInterceptor);
	}
	
//	@Bean  //add @Bean to enable it
	public FilterRegistrationBean timeFilter() {
		
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);
		
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		
		return registrationBean;
		
	}

}
