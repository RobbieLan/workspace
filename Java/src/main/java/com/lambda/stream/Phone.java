package com.lambda.stream;

public class Phone {
	private String phoneName;
	private String phonePrice;
	public Phone(String phoneName, String phonePrice) {
		super();
		this.phoneName = phoneName;
		this.phonePrice = phonePrice;
	}
	public String getPhoneName() {
		return phoneName;
	}
	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}
	public String getPhonePrice() {
		return phonePrice;
	}
	public void setPhonePrice(String phonePrice) {
		this.phonePrice = phonePrice;
	}
	
}
