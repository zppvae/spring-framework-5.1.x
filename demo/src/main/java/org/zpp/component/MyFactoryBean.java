package org.zpp.component;

import org.springframework.beans.factory.FactoryBean;
import org.zpp.importBeanDefinitionRegistrar.BeanDefinitionDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * MyFactoryBean 会注册两个对象
 * 1、它自己
 * 2、getObject() 返回的对象
 *
 * @author zpp
 */
public class MyFactoryBean implements FactoryBean, InvocationHandler {

	Class clazz;

	public MyFactoryBean(Class clazz){
		this.clazz = clazz;
	}
	@Override
	public Object getObject() throws Exception {
		Class[] clazzs = new Class[]{clazz};
		return Proxy.newProxyInstance(this.getClass().getClassLoader(),clazzs,this);
	}

	@Override
	public Class<?> getObjectType() {
		return clazz;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy invoke");
		return null;
	}
}
