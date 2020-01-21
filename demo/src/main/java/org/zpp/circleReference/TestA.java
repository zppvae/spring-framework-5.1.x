package org.zpp.circleReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zpp
 * @date 2020/1/13 16:05
 */
@Component("testA")
public class TestA {

	@Autowired
	private TestB testB;

}
