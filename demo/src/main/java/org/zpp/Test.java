package org.zpp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zpp.beanFactoryProcessor.MyBeanFactoryProcessor;
import org.zpp.config.AppConfig;
import org.zpp.dao.IndexDao;

/**
 * spring 扩展点
 * 1、BeanPostProcessor
 * 2、BeanFactoryPostProcessor
 * 3、BeanDefinitionRegistryPostProcessor
 *
 */
public class Test {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);

		//会被 getBeanFactoryPostProcessors() 扫描到
		applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryProcessor());
		//初始化spring的环境
		applicationContext.refresh();
		IndexDao dao = applicationContext.getBean(IndexDao.class);
		dao.test();
	}
}
