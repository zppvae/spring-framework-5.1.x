package org.zpp.beanFactoryProcessor;

import org.springframework.stereotype.Repository;

/**
 * @author zpp
 * @date 2020/1/15 15:59
 */
@Repository
public class FactoryDao {

	public void print(){
		System.out.println(FactoryDao.class.getSimpleName());
	}
}
