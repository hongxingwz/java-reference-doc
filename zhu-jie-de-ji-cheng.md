# 注解的继承

使用注解@Inherited可以让指定的注解在某个类上使用后，这个类的子类自动被该注解标记

|  | 注解没有＠Inherited | 注解有@Inherited原注解 |
| :--- | :--- | :--- |
| 子类能否继承到父类的类注解 | 否 | 能 |
| 子类重写或实现父类的方法，该方法能否继承父类方法上的注解 | 否 | 否 |
| 子类继承了父类的方法，这个方法能否继承到注解 | 能 | 能 |

结论：我们知道在编写自定义注解时，可以通过指定@Inherited注解，指明白定义注解是否可以被继承



编写类注解验证

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Dengyi {
    String value() default "dengyi";
}
```

```java
@Dengyi
public class Person {}
```

```java
public class Student extends Person {
    public static void main(String[] args) {
        boolean res = Student.class.isAnnotationPresent(Dengyi.class); //true
    }
}
```



