package org.zpp.component;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import org.zpp.dao.IndexDao;
import org.zpp.handler.MyInvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyFactoryBean implements FactoryBean, InvocationHandler {

	Class clazz;

	public MyFactoryBean(Class clazz){
		this.clazz = clazz;
	}
	@Override
	public Object getObject() throws Exception {
		Class[] clazz = new Class[]{IndexDao.class};
		return Proxy.newProxyInstance(this.getClass().getClassLoader(),clazz,this);
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
