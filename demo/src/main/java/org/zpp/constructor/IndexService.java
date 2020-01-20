package org.zpp.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndexService {

	Class clazz;

	public IndexService(Class clazz){
		this.clazz = clazz;
	}


	public void query(){
		System.out.println("query");
		System.out.println(clazz);
	}
}
