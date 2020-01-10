package org.zpp.xml.lookup;

/**
 * @author zpp
 * @date 2020/1/10 11:20
 */
public abstract class GetBeanTest {

	public abstract LookupUser getBean();

	public void showMe(){
		this.getBean().showMe();
	}
}
