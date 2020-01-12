package org.zpp.xml.beanNameAware;

import org.springframework.beans.factory.BeanNameAware;

public class RoleService implements BeanNameAware {

	@Override
	public void setBeanName(String name) {
		name = "roleService";
		System.out.println(name);
	}
}
