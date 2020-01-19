package org.zpp.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MyInvocationHandler implements InvocationHandler {

	Object target;


	public MyInvocationHandler(Object target) {
		super();
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
		System.out.println("-------before-------");
		Object result = method.invoke(target,args);
		System.out.println("-------after--------");
		return result;
	}

	public Object getProxy(){
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				target.getClass().getInterfaces(), this);
	}
}
