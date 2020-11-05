package com.my;

import org.springframework.stereotype.Component;

@Component
public class SomeBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
