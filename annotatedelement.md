# AnnotatedElement

表示目前正在此VM中运行的程序的一个注解元素。此接口允许反射性的读取注解。由此接口中的方法返回的所有注解都是不可变并且可以序列化的。调用者可以修改已赋值数组枚举成员的访问器返回的数组；这不会对其他调用都返回的数组生产任何影响。

getAnnotationsByType\(Class\) 和 getDeclaredAnnotationsByType\(Class\)支持获取一个元素上类型相同的多个注解。如果一个方法上出现了重复的注解类型\(JLS 9.6\)，然后方法会查找其容器注解\(JLS 9.7\),如果出现，返回容器里的所有注解。容器注解可以在编译时生成来包装多个参数类型重复的注解。

directly present, indirectly present, present, and associated 由此接口使用来精确地描述方法返回的是哪种注解

**directly present**

如果E具有RuntimeVisibleAnnotations 或 RuntimeVisibleParameterAnnotations  或 RuntimeVisibleTypeAnnotations属性，并且属性中包含A.我们就说A直接出现在元素E上

**indirectly present**

如果E具有RuntimeVisibleAnnotations 或 RuntimeVisibleParameterAnnotations 或 RuntimeVisibleTypeAnnotations属性，并且A的类型是可重复的，属性包含显示的一个注解，该注解包含A,并且其类型是A类型的容器。我们就是A间接的出现在元素E上。

**present**

如果下面的条件符合我们称A present  E :

* A 直接出现在元素E上
* A没有直接出现在元素E上，并且E是一个类，A类型是可以继承的，A\(present\)出现在了E的父类上了

**associated**

* A 直接或间接的出现在E上
* 注解A类型没有直接或间接的出现在E上，并且E量个类，A类型是可以继承的，A is associated with the superclass of E

定义获取注解的接口，其方法如下

* isAnnotationPresent\(cls\)
* getAnnotation\(cls\)   --------------------------------&gt; **present**
* getAnnotations\(\)      --------------------------------&gt; **present**
* getAnnotationsByType\(cls\)----------------------&gt; **associated**
* getDeclaredAnnotation\(cls\)----------------------&gt; **directly present**
* getDeclaredAnnotations\(\)  ----------------------&gt; **directly present**
* getDeclaredAnnotationsByType\(cls\)--------&gt; **directly present or indirectly present**

## UML类图

![](/assets/屏幕快照 2017-07-16 上午6.56.46.png)

