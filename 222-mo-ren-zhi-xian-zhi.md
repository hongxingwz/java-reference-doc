默认值限制

编译器对元素的默认值有些过分挑剔。

* 元素不能有不确定的值：元素必须要么具有默认值，要么在使用注解时提供元素的值。
* 对于非基本类型的元素，无论是在源代码中声明时，或是在注解接口中定义默认时，都不能以**null**作为其值



这个约束使得处理器很难表现一个元素的存在或缺失状态。为了绕开这个约束，我们只能自己定义一些特殊值，例如空字符或负数，以此表示某个元素不存在：

```java
@Target(ElementType.METHOD）
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatingNull{
    public int id() default -1;
    public String description() default "";
}
```



