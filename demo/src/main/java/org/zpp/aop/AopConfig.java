package org.zpp.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @EnableAspectJAutoProxy：启用AOP的后置处理器
 *
 * {@link org.springframework.aop.framework.DefaultAopProxyFactory}
 *
 */
@ComponentScan("org.zpp.aop")
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
}
