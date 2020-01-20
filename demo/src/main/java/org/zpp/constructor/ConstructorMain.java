package org.zpp.constructor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zpp
 * @date 2020/1/20 10:42
 */
public class ConstructorMain {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ConstructorConfig.class);

		applicationContext.getBean(IndexService.class).query();

	}
}
