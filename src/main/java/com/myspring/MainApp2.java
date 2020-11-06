package com.myspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1 required
//		ApplicationContext context = new ClassPathXmlApplicationContext("mybean.xml");
//		TopManage sb=(TopManage) context.getBean("topManage");
//		System.out.println(sb.getName()+"=="+sb.getAge());
		//   @Autowired @Qualifier
		ApplicationContext context = new ClassPathXmlApplicationContext("mybean.xml");
	      Profile profile = (Profile) context.getBean("profile");
	      profile.printAge();
	      profile.printName();
		
		

	}

}
