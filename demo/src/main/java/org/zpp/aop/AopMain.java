package org.zpp.aop;

import org.springframework.aop.config.AopNamespaceHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zpp.aop.dao.OrderDao;
import org.zpp.aop.dao.OrderDaoBImpl;
import org.zpp.aop.service.OrderServiceImpl;

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

		OrderDao orderDaoB = (OrderDao)applicationContext.getBean(OrderDaoBImpl.class);
		MyInvocationHandler invocationHandler = new MyInvocationHandler(orderDaoB);
		OrderDao proxy = (OrderDao)invocationHandler.getProxy();
		proxy.print("-----");
	}
}
