package com.myspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp3 {
public static void main(String[] args) {
	ApplicationContext ctx=new AnnotationConfigApplicationContext(HelloWorldConfg.class);
	Helloworld hx=(Helloworld) ctx.getBean("hello");
	Helloworld hx2=(Helloworld) ctx.getBean(Helloworld.class);
	System.out.println(hx);
	System.out.println(hx2);
}
}
