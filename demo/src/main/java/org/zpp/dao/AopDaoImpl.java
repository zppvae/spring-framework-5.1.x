package org.zpp.dao;

import org.springframework.stereotype.Component;

@Component
public class AopDaoImpl implements AopDao {

	@Override
	public void print() {
		System.out.println("pringttt");
	}
}
