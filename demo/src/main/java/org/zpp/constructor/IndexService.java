package org.zpp.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndexService {

	public IndexService(){

	}

	@Autowired
	public IndexService(int a){

	}

	public IndexService(int a,int b){

	}
}
