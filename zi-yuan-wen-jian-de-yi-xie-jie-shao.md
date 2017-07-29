# 资源文件的一些介绍

resources\(也就是classpath下的文件\)会直接复制到jar包下

maven生成jar包后，里面会包含META-INF，这里面会包含pom.xml的信息

---

## 1.通过本类的class类的getResource方法

path不以“/"开头时，默认是从此类所在的包下取资源

path以”/"开头时，则是从classPath根下获取资源

## 2.通过本类的ClassLoader的getResource方法

path不能以“/"开头，**path是从ClassPath根下获取**；

所以可以认为：类名.class.getResource\("/"\) == 类名.class.getClassLoader\(\).getResource\(""\)

---

### 3.通过ClassLoader的getSystemResource\(\)，路径和2一致

```
ClassLoader.getSystemResource("dengyi.properties")
ClassLoader.getSystemResource("com/jianglei/properties/Test01.class")
```

---

### 4.通过Thread方式，路径和2一致\(找荐此种\)，Thread.currentThread\(\).getContextClassLoader\(\)

为什么推荐此类？

Test.class.getClassLoader\(\).getResource\(\)，因为你想要获取某个资源文件的时候，这个资源文件的位置是相对固定的。

WEB程序，里面的jar，resources都是由Tomcat内部来加载的，所以你在代码中动态加载jar，资源文件的时候，首先应该是使用Thread.currentThread\(\).getContextClassLoader\(\)。

如果你使用Test.class.getClassLoader\(\),可能会导致和当前线程所运行的类加载器不一致（因为java天生的多线程）



