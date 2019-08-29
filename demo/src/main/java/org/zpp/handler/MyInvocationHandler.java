package org.zpp.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MyInvocationHandler implements InvocationHandler {

	Object target;

	public MyInvocationHandler(){}

	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	/**
	 * @param proxy  代理对象
	 * @param method 目标方法
	 * @param args   目标方法的参数
	 * @return
	 * @throws Throwable proxy logic execute
	 *                   target logic execute
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy ! ! ");
		return null;
	}
}
