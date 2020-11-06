package com.myspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfg {
	@Bean
	public Helloworld hello(){
		return new Helloworld();
	}

}
//<beans>
//<bean id="hello" class="com.myspring.HelloWorldConfg" />
//</beans>