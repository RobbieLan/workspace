package com.wisely.redis.domain;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.wisely.redis.dao.Person;


@Repository
public class PersonDao {
	
	@Autowired
	StringRedisTemplate stringRedisTemplate; //1
	
	@Resource(name="stringRedisTemplate")
	ValueOperations<String,String> valOpsStr; //3
	
	
	@Autowired
	RedisTemplate<Object, Object> redisTemplate; //2
	
	@Resource(name="redisTemplate")
	ValueOperations<Object, Object> valOps; //4
	
	public void stringRedisTemplateDemo(){ //5
//		valOpsStr.set("xx", "yy");
		valOpsStr.set("we", "us");
	}
	
	
	public void save(Person person){ //6
		valOps.set(person.getId(),person);
	}
	
	public String getString(){//7
		return valOpsStr.get("xx");
	}
	
	public Person getPerson(){//8
		return (Person) valOps.get("1");
	}

}
