
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

`GenericBeanDefinition`，用于承载 bean 的属性

## BeanDefinitionHolder

```java
/**
 * BeanDefinitionHolder，一个数据结构，map结构
 * 保存 beanName、BeanDefinition
 */
BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(abd, beanName);
```

## bean的实例化过程

- doCreateBean()创建 BeanWrapper，通过BeanWrapper.getWrappedInstance()获取bean，
然后for循环所有的beanPostProcessor

## bean 的生命周期流程
1、得到用户自定义的BeanDefinitionRegistryPostProcessor
2、得到spring内置的 BeanDefinitionRegistryPostProcessor
3、处理 BeanDefinitionRegistryPostProcessor（遍历）

## bean 的自动装配模型和自动装配技术
https://blog.csdn.net/qq_27409289/article/details/100753656

> 自动装配技术(手动装配)：

`@Resource:` 默认是通过name来查找注入值，如果不存在就报错

`@Autowired：` 通过类型查找(类型)，然后再通过name

> AutowireMode(自动装配模型):在spring中有四种模式分别是: 

- autowire_no： 默认装配模式， 目前非xml配置都是使用这种方式，然后程序员使用注解手动注入
- autowire_name: 通过set方法，并且 set方法的名称需要和bean的name一致     byName
- autowire_type: 通过set方法,并且再根据bean的类型，注入属性，是通过类型配置  byType
- autowire_construcor: 通过构造器注入

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

---

> 7个最重要的BeanPostProcessor

保存在 beanDefinitionMap中

`spring` 后置处理器，贯穿整个 `spring bean` 的实例化前后

```java
ApplicationContextAwareProcessor
ConfigurationClassPostProcessor
ApplicationListenerDetector
PostProcessorRegistrationDelegate#BeanPostProcessorChecker
AutowiredAnnotationBeanPostProcessor
CommonAnnotationBeanPostProcessor
RequiredAnnotationBeanPostProcessor(spring5.1废除)
```

`CommonAnnotationBeanPostProcessor`，处理 `bean` 的生命周期回调

### BeanFactoryPostProcessor

> 典型应用：PropertyPlaceholderConfigurer

spring 内部的处理器通过 addBeanPostProcessor，自定义的通过扫描注解获取


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

## @import可以引入的几种类

- 普通类
- ImportSelector实现类
- ImportBeanDefinitionRegistrar实现类（可以往bdMap中添加一个bd）

## ImportAware

ImportAware 中的方法可以得到 spring 中任意一个注解。

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

## AOP

- @EnableAspectJAutoProxy中的@Import(AspectJAutoProxyRegistrar.class)添加一个AnnotationAutoProxyCreator的后置处理器，
生成bean的代理，proxy可以对bean进行增强


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

## 循环依赖

### 构造器循环依赖
spring 容器将每一个正在创建的 bean 标识符放在一个 ”当前创建bean池”中，
bean 标识符在创建过程中将一直保持在这个池中，因此如果在创建 bean 的过程中
发现自己已经在 “当前创建bean池”里时，将抛出 BeanCurrentlyInCreationException
异常表示循环依赖。而对于创建完毕的bean将从 “当前创建bean池”中清除掉。

此依赖无法解决，只能抛出异常表示循环依赖。

### setter 循环依赖
对于 setter 注入造成的依赖是通过 spring 容器提前暴露刚完成构造器注入但未完成其他步骤
（如setter注入）的 bean来完成的，而且只能解决单例作用域的bean循环依赖。

通过提前`暴露一个单例工厂方法`，从而使其他 bean 能引用到该 bean：

```java
addSingletonFactory(beanName, () -> getEarlyBeanReference(beanName, mbd, bean));
```

### prototype 范围的依赖处理
对于 prototype 作用域 bean，spring 容器无法完成依赖注入，因为spring容器不进行缓存
 prototype 作用域的 bean，因此无法提前暴露一个创建中的 bean。

## jdk与cglib

- 如果目标对象实现了接口，默认情况下会采用jdk的动态代理实现AOP
- 如果目标对象实现了接口，可以强制使用cglib实现AOP
- 如果目标对象没有实现接口，必须采用cglib库，spring会自动在jdk动态代理和cglib之间转换

### jdk动态代理和cglib字节码生成的区别

- jdk动态代理只能对实现了接口的类生成代理，而不能针对类
- cglib 是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法，因为是继承，所以该类
或方法最好不要声明成 final。














