package org.zpp.autoWire;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zpp
 * @date 2020/1/20 11:14
 */
@Configuration
@ComponentScan("org.zpp.autoWire")
@Import(MyImportBeanDefinitionRegister.class)
public class AutoWireConfig {
}
