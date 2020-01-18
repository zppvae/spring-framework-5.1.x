package org.zpp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zpp.aop.AopConfig;
import org.zpp.aop.service.OrderServiceImpl;

/**
 * BeanDefinition：bean的定义
 *
 * AnnotationConfigApplicationContext = BeanDefinitionRegistry
 *
 * spring 扩展点：
 * 1、{@link org.springframework.beans.factory.config.BeanPostProcessor}
 * 2、{@link org.springframework.beans.factory.config.BeanFactoryPostProcessor}
 * 3、{@link org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor}
 * 4、{@link org.springframework.context.annotation.ImportSelector}
 * 5、{@link org.springframework.context.annotation.ImportBeanDefinitionRegistrar}
 *
 * ImportSelector 能做的事情 ImportBeanDefinitionRegistrar都能做，相反则不行
 *
 * import三种情况：
 * 1、ImportSelector（会先放到configurationClasses里，之后再注册）
 * 2、ImportBeanDefinitionRegistrar（会先放到importBeanDefinitionRegistrars里，之后再注册）
 * 3、普通类（会先放到configurationClasses里）
 */
public class Test {

	public static void main(String[] args){

	}

	public static void aopTest(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AopConfig.class);

//		applicationContext.getBean(OrderDao.class).print("targer----");

		applicationContext.getBean(OrderServiceImpl.class).query("B");
	}

}
