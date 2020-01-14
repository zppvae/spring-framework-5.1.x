package org.zpp;

import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zpp.aop.AopConfig;
import org.zpp.aop.service.OrderServiceImpl;
import org.zpp.beanFactoryProcessor.MyBeanFactoryProcessor;
import org.zpp.config.AppConfig;
import org.zpp.dao.IndexDao;
import org.zpp.dao.IndexDao2;
import org.zpp.dao.IndexDaoImpl;
import org.zpp.enhance.TestMethodCallback;

/**
 * BeanDefinition：bean的定义
 *
 * AnnotationConfigApplicationContext = BeanDefinitionRegistry
 *
 * spring 扩展点：
 * 1、{@link org.springframework.beans.factory.config.BeanPostProcessor}
 * 2、{@link org.springframework.beans.factory.config.BeanFactoryPostProcessor}
 * 3、{@link org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor}
 * 4、{@link org.springframework.context.annotation.ImportSelector}
 * 5、{@link org.springframework.context.annotation.ImportBeanDefinitionRegistrar}
 *
 * ImportSelector 能做的事情 ImportBeanDefinitionRegistrar都能做，相反则不行
 *
 * import三种情况：
 * 1、ImportSelector（会先放到configurationClasses里，之后再注册）
 * 2、ImportBeanDefinitionRegistrar（会先放到importBeanDefinitionRegistrars里，之后再注册）
 * 3、普通类（会先放到configurationClasses里）
 */
public class Test {

	public static void main(String[] args){
		testBeanFactoryPostProcessor();
	}

	/**
	 * ComponentScan("org.zpp")
	 * @Configuration
	 *
	 */
	public static void testBeanFactoryPostProcessor(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);

		/**
		 * 添加自定义的 BeanFactoryPostProcessor
		 * 会被 getBeanFactoryPostProcessors() 扫描到
		 */
		applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryProcessor());
		//初始化spring的环境
		applicationContext.refresh();
		IndexDao dao = applicationContext.getBean(IndexDao.class);
		dao.test();
	}

	public static void testScan(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);
		applicationContext.scan("org.zpp");
	}

	public static void test2(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);

		IndexDao dao = (IndexDao)applicationContext.getBean("indexDao");
		dao.test();

	}

	/**
	 * @Import(MyImportSelector.class)
	 */
	public static void test3(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);

		applicationContext.getBean(IndexDao2.class).test();

	}

	/**
	 * cglib 增强
	 */
	public static void test4(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);

		Enhancer enhancer = new Enhancer();
		/**
		 * 增强父类，cglib是通过继承来的
		 */
		enhancer.setSuperclass(IndexDaoImpl.class);
		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
		enhancer.setCallback(new TestMethodCallback());
		IndexDaoImpl indexDao = (IndexDaoImpl)enhancer.create();
		indexDao.test();
	}

	public static void aopTest(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AopConfig.class);

//		applicationContext.getBean(OrderDao.class).print("targer----");

		applicationContext.getBean(OrderServiceImpl.class).query("B");
	}

	public static void testApplicationContext(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);

		applicationContext.getBean("contextDao");
	}

}
