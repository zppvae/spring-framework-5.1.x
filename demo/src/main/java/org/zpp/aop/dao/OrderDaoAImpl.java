package org.zpp.aop.dao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component("orderDao")
public class OrderDaoAImpl implements OrderDao,InitializingBean {

	@Override
	public void print(String sql) {
		System.out.println(sql);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("执行初始化方法");
	}
}
