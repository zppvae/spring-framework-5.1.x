package org.zpp.xml.beanNameAware;

public class UserService {

	private int id;

	private RoleService roleService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
}
