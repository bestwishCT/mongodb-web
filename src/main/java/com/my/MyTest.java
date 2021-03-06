package com.my;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MyTest {
	public static void main(String[] args) {
//1
//        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		XmlBeanFactory factory = new XmlBeanFactory
                (new ClassPathResource("applicationContext.xml"));
		
//        //基于XML配置方式
//        SomeBean sb = ctx.getBean(SomeBean.class);
//        System.out.println(sb);
		  ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		  SomeBean sb = ctx.getBean(SomeBean.class);
		  OtherBean ob = ctx.getBean(OtherBean.class);
		  System.out.println(sb);
		  System.out.println(ob);
		  
		  //体会下这个方法
		  String str = ctx.getBean(String.class);
		  System.out.println(str);
		  //
		  System.exit(0);
    
	}
}
