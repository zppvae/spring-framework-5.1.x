package org.zpp.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zpp.config.AppConfig;

public class ConfigurationMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(Config.class);
		applicationContext.getBean(TestDao.class).query();
	}
}
