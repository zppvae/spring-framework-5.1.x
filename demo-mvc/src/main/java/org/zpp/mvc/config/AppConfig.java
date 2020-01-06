package org.zpp.mvc.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@ComponentScan("org.zpp.mvc")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		System.out.println("json--------");
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		converters.add(converter);
	}
}
