package org.zpp.xml.lookup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zpp
 * @date 2020/1/10 11:21
 */
public class Main {

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("lookUpTest.xml");

		GetBeanTest bean = (GetBeanTest)context.getBean("getBeanTest");
		bean.showMe();
	}
}
