package org.zpp.autoWire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 自动装配模型
 *
 * @author zpp
 * @date 2020/1/20 11:15
 */
public class AutoWireMain {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AutoWireConfig.class);

		System.out.println(applicationContext.getBean(UserService.class).getOrderService());
	}
}
