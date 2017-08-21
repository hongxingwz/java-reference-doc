# AnnotatedType

一个简单的使用案例

```java
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Custom{
}
```

```java
public class Bar{
}
```

```java
public class Foo extends @Custom Bar{

    public static void main(String[] args){
        Class<Foo> fooClass = Foo.class;
        AnnotatedType annotatedType = fooClass.getAnnotatedSuperclass();
        Annotation[] annotations = annotatedtype.getAnnotations();
        System.out.println(Arrays.toString(annotations));
    }
}
/*
[@com4.annotation.Custom()]
*/
```



