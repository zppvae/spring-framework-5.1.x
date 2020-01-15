package org.zpp.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zpp.aop.service.OrderServiceImpl;

/**
 * @author zpp
 * @date 2020/1/15 16:29
 */
public class AopMain {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AopConfig.class);

//		applicationContext.getBean(OrderDao.class).print("targer----");

		applicationContext.getBean(OrderServiceImpl.class).query("B");
	}
}
