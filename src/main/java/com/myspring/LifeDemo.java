package com.myspring;

public class LifeDemo {
	private String message;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return "Print Message is:"+message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public void init(){
		System.out.println("bean init ...");
	}
	public void destroy(){
		System.out.println("bean destroy ...");
	}
}
