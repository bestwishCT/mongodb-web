package com.myspring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class AnotherInitLifeBean implements BeanPostProcessor,Ordered{
	//Bean 后置处理器允许在调用初始化方法前后对 Bean 进行额外的处理(注意是初始化方法前后)
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("1 BeforeInitialization "+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("1 AfterInitialization "+beanName);
		return bean;
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
