# Objects

为了防止该类被实例化，构造器私有化，并在内部抛出一个异常\(经典\)

```java
private Objects() {
    throw new AssertionError("No java.util.Objects instances for you");
```

**public static boolean equals\(Object a, Object b\)**

如果两个对象是同一个实例或两个对象都为null，则返回true

如果一个对象为null，一个对象不为null,则返回false

到最后会返回a.equals\(b\)方法的返回值

```java
public static boolean equals(Object a, Object b){
    return (a == b) || (a != null && a.equals(b));
}
```



