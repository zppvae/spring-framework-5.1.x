package org.zpp.aop.dao;

import org.springframework.stereotype.Component;

@Component("orderDaoB")
public class OrderDaoBImpl implements OrderDao {

	@Override
	public void print(String sql) {
		System.out.println(sql);
	}
}
