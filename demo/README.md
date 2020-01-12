
## BeanFactory

定义获取 bean 以及 bean的各种属性

## HierarchicalBeanFactory
在 BeanFactory 功能的基础上增加了对 parentFactory的支持

## BeanDefinitionRegistry
对 BeanDefinition 的各种增删改操作

## BeanDefinition

定义`bean`的信息

`AnnotatedBeanDefinition`，描述加了注解的类

`RootBeanDefinition`，描述spring内部的类

## GenericBeanDefinition
 用于承载 bean 的属性

## spring 的扩展点：
```java
1、{@link org.springframework.beans.factory.config.BeanPostProcessor}
2、{@link org.springframework.beans.factory.config.BeanFactoryPostProcessor}
3、{@link org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor}
4、{@link org.springframework.context.annotation.ImportSelector}
5、{@link org.springframework.context.annotation.ImportBeanDefinitionRegistrar}
```
### BeanPostProcessor
实现此接口，可以插手 `bean` 的实例化过程。

spring 内部的处理器通过 addBeanPostProcessor，自定义的通过扫描注解获取
 
## 6个最重要的类

保存在 beanDefinitionMap中

```
ConfigurationClassPostProcessor
DefaultEventListenerFactory
EventListenerMethodProcessor
AutowiredAnnotationBeanPostProcessor
CommonAnnotationBeanPostProcessor
RequiredAnnotationBeanPostProcessor(spring5.1.x废除)
```
## BeanDefinitionHolder

```java
/**
 * BeanDefinitionHolder，一个数据结构，map结构
 * 保存 beanName、BeanDefinition
 */
BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(abd, beanName);
```

## DefaultListableBeanFactory

对 `bean` 注册后的处理

```java
//用于排序
private Comparator<Object> dependencyComparator;
//类的描述信息
Map<String, BeanDefinition> beanDefinitionMap;
//所有Bean的名字
List<String> beanDefinitionNames;
//处理延迟加载的功能
private AutowireCandidateResolver autowireCandidateResolver; 
```

## CommonAnnotationBeanPostProcessor
处理 `bean` 的生命周期回调

## bean的实例化过程

- doCreateBean()创建 BeanWrapper，通过BeanWrapper.getWrappedInstance()获取bean，
然后for循环所有的beanPostProcessor

## 循环引用

## ImportAware

https://blog.csdn.net/zgyjk/article/details/80780165
```java

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({RedissonHttpSessionConfiguration.class})
@Configuration
public @interface EnableRedissonHttpSession {
    int maxInactiveIntervalInSeconds() default 1800;
 
    String keyPrefix() default "";
}

@Configuration
public class RedissonHttpSessionConfiguration extends SpringHttpSessionConfiguration implements ImportAware {
    private Integer maxInactiveIntervalInSeconds;
    private String keyPrefix;
 
    public void setImportMetadata(AnnotationMetadata importMetadata) {
    	//得到类名上的注解，并修改注解上的属性值
        Map<String, Object> map = importMetadata.getAnnotationAttributes(EnableRedissonHttpSession.class.getName());
        AnnotationAttributes attrs = AnnotationAttributes.fromMap(map);
        this.keyPrefix = attrs.getString("keyPrefix");
        this.maxInactiveIntervalInSeconds = (Integer)attrs.getNumber("maxInactiveIntervalInSeconds");
    }
}
```
## bean的后置处理器

- ApplicationContextAwareProcessor
- PostProcessorRegistrationDelegate
- ApplicationListenerDetector
- ConfigurationClassPostProcessor
- RequiredAnnotationBeanPostProcessor（处理@Required）

`spring` 后置处理器，贯穿整个 `spring bean` 的实例化前后

## AOP

- @EnableAspectJAutoProxy中的@Import(AspectJAutoProxyRegistrar.class)添加一个AnnotationAutoProxyCreator的后置处理器，
生成bean的代理，proxy可以对bean进行增强

## bean 的自动装配模型和自动装配技术
https://blog.csdn.net/qq_27409289/article/details/100753656

## DefaultSingletonBeanRegistry
```java
//用于存放完全初始化好的 bean，从该缓存中取出的 bean可以直接使用
private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

//存放 bean工厂对象，解决循环依赖
private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);

//存放原始的 bean对象，用于解决循环依赖（存放到里面的对象还没有被填充属性），
// 判断属性的类型匹配时，从这个map中获取 bean
private final Map<String, Object> earlySingletonObjects = new HashMap<>(16);
```

## 属性注入

找到目标对象（属性）完成注入的方式：byName、byType。

> 属性填充：
```java
public class Test{
  private X x;
}
```

- 构造方法
```java
public Test(X x){}
```
- field.set(x);（反射）
```java
@Autowired
private X x;
```
- set方法注入
```java
@Autowired
public void set(X x){}
```
