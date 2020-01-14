package org.zpp.applicationEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author zpp
 * @date 2020/1/14 17:54
 */
public class TestListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof TestEvent) {
			TestEvent testEvent = (TestEvent)event;
			testEvent.print();
		}
	}
}
