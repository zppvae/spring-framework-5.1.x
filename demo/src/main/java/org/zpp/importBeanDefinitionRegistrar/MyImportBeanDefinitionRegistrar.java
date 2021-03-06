package org.zpp.importBeanDefinitionRegistrar;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.zpp.component.MyFactoryBean;

/**
 * 与mybatis 的 @MapperScan原理相同
 *
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//得到 BeanDefinition，以下可以通过扫描包动态获取 BeanDefinition
		//扫描所有接口
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(BeanDefinitionDao.class);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)builder.getBeanDefinition();

		//参考 @MapperScan源码
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
		beanDefinition.setBeanClass(MyFactoryBean.class);
		registry.registerBeanDefinition("beanDefinitionDao",beanDefinition);
	}
}
