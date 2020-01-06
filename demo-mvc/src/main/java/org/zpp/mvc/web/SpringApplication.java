package org.zpp.mvc.web;

import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.zpp.mvc.config.AppConfig;


public class SpringApplication {

	public static void run(){
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8000);
		tomcat.addWebapp("/","D:\\zl\\");

		try{
			AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
			context.register(AppConfig.class);
//			context.refresh();

			//加载web环境
			DispatcherServlet servlet = new DispatcherServlet(context);
			Wrapper mvc = tomcat.addServlet("/","mvc",servlet);
			mvc.addMapping("*.do");
			/**
			 * 容器启动时会执行 {@link org.springframework.web.servlet.HttpServletBean 的 init发能发
			 */
			mvc.setLoadOnStartup(1);
			tomcat.start();
			tomcat.getServer().await();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
