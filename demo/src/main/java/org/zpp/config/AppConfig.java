package org.zpp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.zpp.annotation.DemoScan;
import org.zpp.annotation.EnableImport;
import org.zpp.beanDefinition.MyImportBeanDefinitionRegistrar;
import org.zpp.component.MyImportSelector;

/**
 * @Configuration
 * @ComponentScan("org.zpp")
 * @DemoScan
 *
 * @ComponentScan("org.zpp")
 * @EnableImport
 */
@ComponentScan("org.zpp")
@EnableImport
public class AppConfig {
}
