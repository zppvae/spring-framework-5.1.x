# spring bean 生命周期

## BeanDefinition

定义`bean`的信息

`AnnotatedBeanDefinition`，描述加了注解的类

`RootBeanDefinition`，描述spring内部的类

## 6个最重要的类

```
ConfigurationClassPostProcessor
DefaultEventListenerFactory
EventListenerMethodProcessor
AutowiredAnnotationBeanPostProcessor
CommonAnnotationBeanPostProcessor
RequiredAnnotationBeanPostProcessor(spring5.1.x废除)
```
## BeanDefinitionHolder

```
/**
 * BeanDefinitionHolder，一个数据结构，map结构
 * 保存 beanName、BeanDefinition
 */
BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(abd, beanName);
```

## DefaultListableBeanFactory

```
//用于排序
private Comparator<Object> dependencyComparator;
//类的描述信息
Map<String, BeanDefinition> beanDefinitionMap;
//所有Bean的名字
List<String> beanDefinitionNames;
//处理延迟加载的功能
private AutowireCandidateResolver autowireCandidateResolver 
```

## CommonAnnotationBeanPostProcessor
处理 `bean` 的生命周期回调

## spring bean的实例化过程

## 循环引用