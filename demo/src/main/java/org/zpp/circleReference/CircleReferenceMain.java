package org.zpp.circleReference;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 循环引用
 *
 * @author zpp
 * @date 2020/1/13 16:06
 */
public class CircleReferenceMain {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(CircleReferenceConfig.class);

		System.out.println(applicationContext.getBean("testA"));
	}
}
