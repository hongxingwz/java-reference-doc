```
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Roles.class)
public @interface Role{
    String name() default "doctor";
}
```

```
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ROLES{
    Role[] value();
}
```

```
@Role(name="doctor")
@Role(name="jianglei")
public class RepeatAnn{}
```

```
@Roles(value = {
    @Role(name="doctor"),
    @Role(name="jianglei")})
public class Annotations{}
```

最终通过反射得到的都是下面的结果

```
@com.jianglei.repeatable.Roles(
value=[@com.jianglei.repeatable.Role(name=doctor), @com.jianglei.repeatable.Role(name=who)])
```



