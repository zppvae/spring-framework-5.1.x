package org.zpp.propertyEditor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zpp
 * @date 2020/1/14 15:29
 */
public class PropertyEditorTest {

	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("propertyEditorTest.xml");
		UserManager um = (UserManager)ac.getBean("userManager");
		System.out.println(um);
	}
}
