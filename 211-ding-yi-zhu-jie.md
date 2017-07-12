# 定义注解

下面就是上章中用到的注解**@Test**的定义。可以看到，注解的定义看起来很像接口的定义。事实上，与其他任何Java接口一样，注解也将会编译成**class**文件

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNNTIME)
public @interface Test{

}
```

没有元素的注解称为标记注解\(marker annotation\)，例如上例中的**@Test**





