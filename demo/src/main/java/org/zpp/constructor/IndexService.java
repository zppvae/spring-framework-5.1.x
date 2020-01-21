package org.zpp.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndexService {


	private Class clazz;

	public IndexService(){}

	public IndexService(Class clazz){
		this.clazz = clazz;
	}

	public IndexService(Class clazz,Object o1){
		this.clazz = clazz;
	}

	public IndexService(Class clazz,Integer i){
		this.clazz = clazz;
	}

	public void query(){
		System.out.println("query");
	}
}
