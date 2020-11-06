package com.myspring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class TopManage {
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
//	@Required
	@Autowired
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
//	@Required
	@Autowired
	public void setAge(Integer age) {
		this.age = age;
	}
	

}
