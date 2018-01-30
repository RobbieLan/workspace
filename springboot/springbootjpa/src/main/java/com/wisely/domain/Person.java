package com.wisely.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity //1 Infer that this entity is mapped with a table in database
@NamedQuery(name = "Person.withNameAndAddressNamedQuery",
query = "select p from Person p where p.name=?1 and address=?2")
public class Person {
	@Id //2 This property is mapped to the PK of the table
	@GeneratedValue //3 Hibernate will generate a sequence named "HIBERNATE_SEQUENCE"(Applicable in Oracle, but if it is MySQL?)
	private Long id;
	//We dont use @Table and @Column because here Hibernate generate table for us rather than generate entity from table
	//and the column names in table will be adapted to database style automatically e.g. name->NAME; testName->TEST_NAME
	private String name;
	//We need to use wrapped class rather than primitive types, because the latter would be initialized as 0 other than null, which would result in failure in condition construction
	private Integer age;
	
	private String address;
	
	
	
	public Person() {
		super();
	}
	public Person(Long id, String name, Integer age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}
