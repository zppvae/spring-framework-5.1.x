package org.zpp.dao;

import org.springframework.stereotype.Repository;

@Repository("indexDao")
public class IndexDaoImpl implements IndexDao{

	public void test(){
		System.out.println("index dao 3");
	}
}
