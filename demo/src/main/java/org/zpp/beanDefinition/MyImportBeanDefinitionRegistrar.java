package org.zpp.beanDefinition;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.zpp.Test;
import org.zpp.component.MyFactoryBean;
import org.zpp.dao.IndexDao;
import org.zpp.handler.MyInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * 与mybatis 的 @MapperScan原理相同
 *
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//得到 BeanDefinition，以下可以通过扫描包动态获取 BeanDefinition
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(IndexDao.class);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)builder.getBeanDefinition();

		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
		beanDefinition.setBeanClass(MyFactoryBean.class);
		registry.registerBeanDefinition("indexDao",beanDefinition);
	}
}
