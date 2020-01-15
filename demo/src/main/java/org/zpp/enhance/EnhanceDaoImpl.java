package org.zpp.enhance;

import org.springframework.stereotype.Repository;

/**
 * @author zpp
 * @date 2020/1/15 16:26
 */
@Repository("enhanceDao")
public class EnhanceDaoImpl implements EnhanceDao {

	@Override
	public void print() {
		System.out.println(EnhanceDaoImpl.class.getSimpleName() + "# print()");
	}
}
