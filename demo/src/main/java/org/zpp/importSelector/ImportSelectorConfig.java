package org.zpp.importSelector;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zpp
 * @date 2020/1/15 16:14
 */
@Configuration
@ComponentScan("org.zpp.importSelector")
@Import(MyImportSelector.class)
public class ImportSelectorConfig {
}
