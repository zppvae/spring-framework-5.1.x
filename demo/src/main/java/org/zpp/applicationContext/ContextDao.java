package org.zpp.applicationContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

//@Repository
public class ContextDao implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public ContextDao(){
		System.out.println("默认构造方法");
	}

	@PostConstruct
	public void init(){
		System.out.println("-- init ---");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("applicationContext: "+applicationContext);
	}
}
