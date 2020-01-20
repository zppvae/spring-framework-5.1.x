package org.zpp.autoWire;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		GenericBeanDefinition  userService =
				(GenericBeanDefinition) registry.getBeanDefinition("userService");
		//设置 userService 属性装配模型
		userService.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);
		registry.registerBeanDefinition("userService", userService);
	}
}