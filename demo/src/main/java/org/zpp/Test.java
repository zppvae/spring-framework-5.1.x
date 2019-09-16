package org.zpp;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.event.DefaultEventListenerFactory;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.zpp.beanFactoryProcessor.MyBeanFactoryProcessor;
import org.zpp.config.AppConfig;
import org.zpp.dao.IndexDao;
import org.zpp.dao.IndexDao2;

/**
 * BeanDefinition：bean的定义
 *
 * AnnotationConfigApplicationContext = BeanDefinitionRegistry
 *
 * spring 扩展点
 * 1、BeanPostProcessor
 * 2、BeanFactoryPostProcessor
 * 3、BeanDefinitionRegistryPostProcessor
 *
 */
public class Test {

	public static void main(String[] args){
		test3();
	}

	public static void test(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);

		//会被 getBeanFactoryPostProcessors() 扫描到
		applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryProcessor());
		//初始化spring的环境
		applicationContext.refresh();
//		IndexDao dao = applicationContext.getBean(IndexDao.class);
//		dao.test();
	}

	public static void test2(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);

		IndexDao dao = (IndexDao)applicationContext.getBean("indexDao");
		dao.test();

	}

	/**
	 * @Import(MyImportSelector.class)
	 */
	public static void test3(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);

		applicationContext.getBean(IndexDao2.class).test();

	}
}
