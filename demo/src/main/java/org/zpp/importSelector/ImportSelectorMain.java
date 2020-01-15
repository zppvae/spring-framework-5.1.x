package org.zpp.importSelector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zpp
 * @date 2020/1/15 16:14
 */
public class ImportSelectorMain {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ImportSelectorConfig.class);

		applicationContext.getBean(ImportSelectorDao.class).print();
	}
}
