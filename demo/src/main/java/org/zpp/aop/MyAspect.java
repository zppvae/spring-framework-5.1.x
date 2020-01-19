package org.zpp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

	@After("pointCut()")
	public void after(){
		System.out.println("proxy after");
	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint point){
		System.out.println("before1");
		Object o = null;
		try{
			o = point.proceed();
		}catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("after1");
		return o;
	}
}
