package org.zpp.enhance;

import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.zpp.dao.IndexDaoImpl;

/**
 * @author zpp
 * @date 2020/1/15 16:27
 */
public class EnhanceMain {

	public static void main(String[] args){
		Enhancer enhancer = new Enhancer();
		/**
		 * 增强父类，cglib是通过继承来的
		 */
		enhancer.setSuperclass(EnhanceDaoImpl.class);
		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
		enhancer.setCallback(new TestMethodCallback());
		EnhanceDaoImpl indexDao = (EnhanceDaoImpl)enhancer.create();
		indexDao.print();
	}
}
