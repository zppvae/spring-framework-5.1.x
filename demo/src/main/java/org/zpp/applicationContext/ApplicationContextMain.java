package org.zpp.applicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ApplicationContext 扩展了 BeanFactory中现有的功能
 *
 * @author zpp
 * @date 2020/1/14 14:30
 */
public class ApplicationContextMain {

	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextTest.xml");
	}
}
