package org.zpp.xml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zpp
 * @date 2020/1/8 17:59
 */
public class XmlTest {

	public static void main(String[] args){
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
		MyTestBean bean = beanFactory.getBean(MyTestBean.class);

		System.out.println(bean.getTestStr());
	}
}
