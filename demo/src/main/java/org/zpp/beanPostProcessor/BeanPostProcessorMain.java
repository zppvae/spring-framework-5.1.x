package org.zpp.beanPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zpp
 * @date 2020/1/15 15:41
 */
public class BeanPostProcessorMain {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);

		applicationContext.getBean("beanPostProcessorDao");
	}
}
