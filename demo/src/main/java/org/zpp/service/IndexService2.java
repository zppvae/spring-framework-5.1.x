package org.zpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("index2")
public class IndexService2 {

	/**
	 * 测试循环引用
	 */
	@Autowired
	private IndexService1 indexService1;

	public IndexService2(){
		System.out.println("indexservice 2");
	}
}
