package org.zpp.xml.replace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zpp
 * @date 2020/1/10 13:46
 */
public class ReplaceMethodMain {

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("replaceMethodTest.xml");

		TestChangeMethod tcm = (TestChangeMethod)context.getBean("testChangeMethod");
		tcm.changeMe();
	}
}
