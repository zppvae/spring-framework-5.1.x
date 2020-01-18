package org.zpp.configuration;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestMethodCallback implements MethodInterceptor {

	/**
	 *
	 * @param o
	 * 			代理对象
	 * @param method
	 * @param objects
	 * 			参数
	 * @param methodProxy
	 * 			代理方法
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("method intercept");
		return methodProxy.invokeSuper(o,objects);
	}
}
