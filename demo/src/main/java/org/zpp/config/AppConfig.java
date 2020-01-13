package org.zpp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration
 * @ComponentScan("org.zpp")
 * @DemoScan（推荐）
 *
 * @ComponentScan("org.zpp")
 * @EnableImport
 *
 * @ComponentScan("org.zpp")
 * @EnableImport
 */
@ComponentScan("org.zpp")
@Configuration
public class AppConfig {

	/**
	 * cglib：操作字节码，基于父类
	 *
	 * AppConfig加了 @Configuration，会进行 cglib代理
	 * 加了 static 会执行多次
	 *
	 * @ComponentScan("org.zpp")
	 * @Configuration
	 *
	 * @return
	 */
//	@Bean
//	public IndexDao2 indexDao2(){
//		return new IndexDao2();
//	}
//
//	@Bean
//	public IndexDao indeDao(){
//		indexDao2();
//		return new IndexDaoImpl();
//	}
}
