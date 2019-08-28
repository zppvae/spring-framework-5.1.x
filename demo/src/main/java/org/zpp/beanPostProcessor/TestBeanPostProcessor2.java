package org.zpp.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * 自定义的spring会扫描到，而spring默认的会通过 set的方式设置
 *
 * BeanPostProcessor：插手bean的初始化过程
 */
@Component
public class TestBeanPostProcessor2 implements BeanPostProcessor, PriorityOrdered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("indexDao")) {
			System.out.println("BeforeInitialization 2");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("indexDao")) {
			System.out.println("AfterInitialization 2");
		}
		return bean;
	}

	/**
	 * 设置执行顺序
	 * @return
	 */
	@Override
	public int getOrder() {
		return 100;
	}
}
