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

## 注意注解继承的传递性：

如果被标注为@Inherited某注解 用在一个父类上，则其子类，孙子类都可以通过反射获取该注解

```java
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Dengyi{
    String value() default "";
}
```

```java
@Dengyi
public class A {
}
```

```java
public class B extends A{
}
```

```java
public class C extends B{

    public static void main(String[] args){
        Class<?> clz = C.class;
        Dengyi dengyi = clz.getAnnotation(Dengyi.class);
        System.out.println(dengyi);
    }
}
```

## 重写或实现方法会覆盖掉原有方法的注解

这个应当这样理解  


```java
public interface Map{
    @Dengyi
    void put();
}
```

```java
public class HashMap implements Map{
    @Override
    public void put(){  //这里相当于把接口的方法想覆盖掉了，当然就没有原来方法的注解了
    }
    
    public static void main (String[] args) throws NoSuchMethodException{
        Class<HashMap> clz = HashMap.class;
        Method put = clz.getMethod("put");
        Dengyi annotation = put.getAnnotation(Dengyi.class);
        System.out.println(annotation); //output: null 
        
        Class<Map> clz2 = Map.class;
        Method put2 = clz2.getMethod("put")
        Dengyi dengyi = put2.getAnnotation(Dengyi.class);
        System.out.println(dengyi); //output: @com.jianglei3.bean.Dengyi(value=)
    }
}
```

## 子类继承父类的方法会继承注解

因为子类掉用父类方法时，会去父类寻找该方法的信息

```java
public class MMap{
    @Dengyi
    public void put(){}
}
```

```java
public class HashMap extend MMap{

    public static void main(String[] args) throws NoSuchMethodException{
        Method method = MMap.class.getMethod("put");
        Annotation dengyi = method.getAnnotation(Dengyi.class); 
        System.out.println(dengyi); //output: @com.jianglei3.bean.Dengyi(value=)

}
```



