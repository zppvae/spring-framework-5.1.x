package org.zpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("index1")
public class IndexService1 {

	/**
	 * 测试循环引用
	 */
	@Autowired
	private IndexService2 indexService2;

	public IndexService1(){
		System.out.println("indexservice 1");
	}
}
