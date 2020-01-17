package org.zpp.circleReference;

/**
 * @author zpp
 * @date 2020/1/13 16:05
 */
public class TestC {

	private TestA testA;

	public TestC(TestA testA){

	}

	public TestA getTestA() {
		return testA;
	}

	public void setTestA(TestA testA) {
		this.testA = testA;
	}
}
