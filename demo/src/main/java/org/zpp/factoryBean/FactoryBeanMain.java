package org.zpp.factoryBean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zpp
 * @date 2020/1/13 14:04
 */
public class FactoryBeanMain {

	public static void main(String[] args){
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("factoryBeanTest.xml"));
		/**
		 * spring通过反射机制发现 CarFactoryBean实现了FactoryBean接口，
		 * 此时会调用org.zpp.factoryBean.CarFactoryBean#getObject()返回结果
		 */
		Car car = (Car)beanFactory.getBean("car");
		System.out.println(""+car);

		/**
		 * 获取 CarFactoryBean 的实例，前面加 &
		 */
		CarFactoryBean carFactoryBean = (CarFactoryBean)beanFactory.getBean("&car");
		System.out.println("CarFactoryBean："+carFactoryBean);
	}
}
