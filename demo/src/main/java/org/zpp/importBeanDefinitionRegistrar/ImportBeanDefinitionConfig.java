package org.zpp.importBeanDefinitionRegistrar;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.zpp.annotation.ScanBean;

@Configuration
@ComponentScan(basePackages = {"org.zpp.importBeanDefinitionRegistrar","org.zpp.component","org.zpp.annotation"})
@ScanBean
public class ImportBeanDefinitionConfig {
}
