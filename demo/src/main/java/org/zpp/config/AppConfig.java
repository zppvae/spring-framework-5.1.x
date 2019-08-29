package org.zpp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.zpp.annotation.DemoScan;
import org.zpp.beanDefinition.MyImportBeanDefinitionRegistrar;

@Configuration
@ComponentScan("org.zpp")
@DemoScan
public class AppConfig {
}
