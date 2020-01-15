package org.zpp.beanFactoryProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;


public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		/**
		 * 插手 bean工厂初始化
		 */
		AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) beanFactory.getBeanDefinition("factoryDao");
		//每次获取的 factoryDao 都是不同的
		beanDefinition.setScope("prototype");
	}
}
