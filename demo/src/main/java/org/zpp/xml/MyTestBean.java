package org.zpp.xml;

/**
 * @author zpp
 * @date 2020/1/8 17:58
 */
public class MyTestBean {

	private String testStr = "testStr";


	public MyTestBean(){}

	public MyTestBean(int a,int b){
		System.out.println("a + b = " + (a + b));
	}

	public MyTestBean(String testStr){
		this.testStr = testStr;
	}

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}
}
