package org.zpp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	@Pointcut("execution(* org.zpp.aop.dao..*.*(..))")
	public void pointCut(){
	}

	@Before("pointCut()")
	public void before(){
		System.out.println("proxy before");
	}
}
