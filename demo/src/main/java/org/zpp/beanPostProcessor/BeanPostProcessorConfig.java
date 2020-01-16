package org.zpp.beanPostProcessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zpp
 * @date 2020/1/15 15:41
 */
@Configuration
@ComponentScan("org.zpp.beanPostProcessor")
public class BeanPostProcessorConfig {

	@Bean
	public  BeanPostProcessorDao beanPostProcessorDao(){
		return new BeanPostProcessorDao();
	}
}
