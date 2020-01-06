package org.zpp.aop.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.zpp.aop.dao.OrderDao;

import java.util.Map;

/**
 * 根据不同的参数调用对应的Dao处理有两种方式：
 *   1、实现 ApplicationContextAware接口
 *   2、注入
 *    @Autowired
 *    private Map<String,OrderDao> orderDaoMap;
 *
 */
@Service
public class OrderServiceImpl implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	/**
	 * 收集所有实现了OrderDao接口的实现类
	 */
	@Autowired
	private Map<String,OrderDao> orderDaoMap;

	public void query(String username){
		if (username.equals("A")) {
			OrderDao orderDao = (OrderDao)applicationContext.getBean("orderDaoAImpl");
			orderDao.print("orderDaoA");
		} else {
			OrderDao orderDao = (OrderDao)applicationContext.getBean("orderDaoBImpl");
			orderDao.print("orderDaoB");
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
