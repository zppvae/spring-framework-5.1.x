package org.zpp.configuration;

public class TestDao implements Dao{

	public TestDao(){
		System.out.println("testdao");
	}

	@Override
	public void query(){
		System.out.println("query");
	}
}
