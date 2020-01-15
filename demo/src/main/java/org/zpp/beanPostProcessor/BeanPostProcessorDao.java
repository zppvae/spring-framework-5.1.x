package org.zpp.beanPostProcessor;

import org.springframework.stereotype.Repository;

/**
 * @author zpp
 * @date 2020/1/15 15:39
 */
@Repository
public class BeanPostProcessorDao {

	public void print(){
		System.out.println(BeanPostProcessorDao.class.getSimpleName());
	}
}
