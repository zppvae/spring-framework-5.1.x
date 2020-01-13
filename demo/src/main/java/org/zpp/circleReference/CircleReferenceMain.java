package org.zpp.circleReference;

import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 循环引用
 *
 * @author zpp
 * @date 2020/1/13 16:06
 */
public class CircleReferenceMain {

	public static void main(String[] args){
	    try {
	    	new ClassPathXmlApplicationContext("circleReferenceTest.xml");
		}catch (Exception e) {
	    	e.printStackTrace();
		}
	}
}
