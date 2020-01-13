package org.zpp.importBeanDefinitionRegistrar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ImportBeanDefinitionConfig.class);

		applicationContext.getBean("beanDefinitionDao");

	}
}
