package org.zpp.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class OrderDaoAImpl implements OrderDao {

	@Override
	public void print(String sql) {
		System.out.println(sql);
	}
}
