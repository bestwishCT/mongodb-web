package com.my;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 作为Spring的主配置文件
//@Configuration标签表示这个类可被Spring识别的配置对象的类,只有有这个标记的标签的类才能使用@Bean标签作用于对应的方法上面
//@ComponentScan:开启组件自动扫描；默认情况下，它会扫描当前类所在的包及其子包中的所有标签对象加载到Spring容器
@Configuration
@ComponentScan(basePackages="com.my")
public class AppConfig {
	// @Bean标签表示让Spring帮我们管理bean
	@Bean
	public SomeBean someBean() {
		return new SomeBean();
	}

	@Bean
	public OtherBean otherBean() {
		return new OtherBean();
	}
	
	@Bean
	public String sayHello() {
		return "hello";
	}
}
