package org.zpp.beanFactoryProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zpp
 * @date 2020/1/15 16:01
 */
public class FactoryProcessorMain {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext();

		applicationContext.register(FactoryProcessorConfig.class);

		/**
		 * 添加自定义的 BeanFactoryPostProcessor
		 * 会被 getBeanFactoryPostProcessors() 扫描到
		 */
		applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryProcessor());

		applicationContext.refresh();

		FactoryDao dao1 = (FactoryDao)applicationContext.getBean("factoryDao");
		FactoryDao dao2 = (FactoryDao)applicationContext.getBean("factoryDao");
		System.out.println(dao1 == dao2);
	}
}
