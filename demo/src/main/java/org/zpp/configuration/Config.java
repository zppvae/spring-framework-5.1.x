package org.zpp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("org.zpp.configuration")
public class Config {

	@Bean
	public TestDao testDao(){
		return new TestDao();
	}
}
