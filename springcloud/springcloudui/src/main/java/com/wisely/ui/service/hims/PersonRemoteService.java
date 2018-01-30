//package com.wisely.ui.service.hims;
//
//import java.util.List;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.wisely.ui.domain.Person;
//import com.wisely.ui.service.hims.hystrix.PersonRemoteServiceHystrix;
//
//@FeignClient(name = "springcloudperson",fallback = PersonRemoteServiceHystrix.class)
//public interface PersonRemoteService {
//	@RequestMapping(method = RequestMethod.POST, value = "/save",
//            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody List<Person> save(@RequestBody String  name);
//}
