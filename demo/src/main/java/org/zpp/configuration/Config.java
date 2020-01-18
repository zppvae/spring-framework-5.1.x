package org.zpp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration，加了此注解表示是一个全注解（full标识），会被cglib代理，
 * 实现 BeanFactoryAware接口，产生一个 beanFactory，当调用方法的时候，会判断是不是第一次调用，
 * 如果是第一次调用，直接 new（ new TestDao3()），如果不是，则从 beanFactory#getBean() 中返回。
 */
@Configuration
@ComponentScan("org.zpp.configuration")
public class Config {

	/**
	 * 加了 static ，在调用testDao3()会执行多次
	 * @return
	 */
	@Bean
	public TestDao3 testDao3(){
		return new TestDao3();
	}

	@Bean
	public TestDao2 testDao2(){
		//加上 @Configuration只会调用一次
		testDao3();
		return new TestDao2();
	}
}
