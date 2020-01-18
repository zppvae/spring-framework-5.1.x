package org.zpp.configuration;

import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(Config.class);

		Enhancer enhancer = new Enhancer();
		/**
		 * 增强父类，cglib是通过继承来的
		 */
		enhancer.setSuperclass(TestDao.class);
		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
		enhancer.setCallback(new TestMethodCallback());
		TestDao indexDao = (TestDao)enhancer.create();
		indexDao.query();
	}
}
