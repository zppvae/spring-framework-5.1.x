package org.zpp.applicationEvent;

import org.springframework.context.ApplicationEvent;

/**
 * @author zpp
 * @date 2020/1/14 17:53
 */
public class TestEvent extends ApplicationEvent {

	public String msg;

	public TestEvent(Object source) {
		super(source);
	}

	public TestEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public void print(){
		System.out.println("event："+msg);
	}
}
