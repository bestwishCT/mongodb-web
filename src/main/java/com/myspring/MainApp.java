package com.myspring;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1 singleton prototype 区别
		ApplicationContext context = new ClassPathXmlApplicationContext("mybean.xml");
//		Helloworld objA=(Helloworld) context.getBean("helloWorld");
//		objA.setMessage("hex");
//		objA.getMessage();
//		Helloworld objB = (Helloworld) context.getBean("helloWorld");
//	    objB.getMessage();
//	    System.out.println(objA);
//	    System.out.println(objB);
		//2 生命周期
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("mybean.xml");
//		LifeDemo lifeDemo=(LifeDemo) context.getBean("lifeDemo");
//		System.out.println(lifeDemo.getMessage());
//		//它将确保正常关闭，并且调用相关的 destroy 方法
//		context.registerShutdownHook();
		//DI
		SpringDIByStru sb=(SpringDIByStru) context.getBean("springDIByStru");
		sb.diDesc();
		
		

	}

}
