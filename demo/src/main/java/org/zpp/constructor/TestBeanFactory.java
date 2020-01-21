package org.zpp.constructor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class TestBeanFactory implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition bd = (GenericBeanDefinition)beanFactory.getBeanDefinition("indexService");
		bd.getConstructorArgumentValues().addGenericArgumentValue("org.zpp.constructor.DeptService");
		bd.getConstructorArgumentValues().addGenericArgumentValue(1,"java.lang.Integer");
	}
}
