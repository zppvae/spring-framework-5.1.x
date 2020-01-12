package org.zpp.xml.beanNameAware;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanNameAwareMain {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanNameAwareTest.xml"));
		UserService userService = (UserService) beanFactory.getBean("userService");
		System.out.println(userService.getRoleService());
	}
}
