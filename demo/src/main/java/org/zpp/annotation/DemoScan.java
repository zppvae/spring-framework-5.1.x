package org.zpp.annotation;


import org.springframework.context.annotation.Import;
import org.zpp.beanDefinition.MyImportBeanDefinitionRegistrar;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportBeanDefinitionRegistrar.class)
public @interface DemoScan {
}
