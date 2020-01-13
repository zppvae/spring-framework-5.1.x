package org.zpp.circleReference;

/**
 * @author zpp
 * @date 2020/1/13 16:05
 */
public class TestA {
	private TestB testB;

	public TestB getTestB() {
		return testB;
	}

	public void setTestB(TestB testB) {
		this.testB = testB;
	}
}
