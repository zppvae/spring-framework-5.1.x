package org.zpp.aop;

import org.springframework.aop.config.AopNamespaceHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zpp.aop.dao.OrderDao;
import org.zpp.aop.dao.OrderDaoBImpl;
import org.zpp.aop.service.OrderServiceImpl;
import org.zpp.aop.service.UserService;
import org.zpp.aop.service.UserServiceImpl;

/**
 * {@link AopNamespaceHandler}
 *
 *
 * @author zpp
 * @date 2020/1/15 16:29
 */
public class AopMain {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AopConfig.class);

//		applicationContext.getBean(OrderDao.class).print("targer----");

		applicationContext.getBean(OrderServiceImpl.class).query("B");

		UserService userService = new UserServiceImpl();

		MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
		UserService proxy = (UserService)invocationHandler.getProxy();
		proxy.add();
	}
}
