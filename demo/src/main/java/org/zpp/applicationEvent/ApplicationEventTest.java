package org.zpp.applicationEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 观察者模式
 *
 * @author zpp
 * @date 2020/1/14 17:56
 */
public class ApplicationEventTest {

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationEventTest.xml");
		TestEvent event = new TestEvent("hello","I am event msg !");
		context.publishEvent(event);
	}
}
